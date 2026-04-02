import axios from 'axios'

const baseURL = import.meta.env.VITE_API_BASE || 'http://127.0.0.1:8000/api'

export const api = axios.create({ baseURL })

api.interceptors.request.use((config) => {
  const access = localStorage.getItem('access')
  if (access) {
    config.headers.Authorization = `Bearer ${access}`
  }
  return config
})

let refreshPromise = null

api.interceptors.response.use(
  (r) => r,
  async (error) => {
    const original = error.config
    if (error.response?.status !== 401 || original._retry) {
      return Promise.reject(error)
    }
    const refresh = localStorage.getItem('refresh')
    if (!refresh) {
      return Promise.reject(error)
    }
    original._retry = true
    if (!refreshPromise) {
      refreshPromise = axios
        .post(`${baseURL}/auth/token/refresh/`, { refresh })
        .then((res) => {
          localStorage.setItem('access', res.data.access)
          return res.data.access
        })
        .finally(() => {
          refreshPromise = null
        })
    }
    try {
      const access = await refreshPromise
      original.headers.Authorization = `Bearer ${access}`
      return api(original)
    } catch {
      localStorage.removeItem('access')
      localStorage.removeItem('refresh')
      return Promise.reject(error)
    }
  }
)
