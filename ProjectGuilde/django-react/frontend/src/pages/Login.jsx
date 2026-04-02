import { useState } from 'react'
import { Link, useNavigate, useLocation } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

export default function Login() {
  const { login } = useAuth()
  const nav = useNavigate()
  const { state } = useLocation()
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [err, setErr] = useState('')

  async function onSubmit(e) {
    e.preventDefault()
    setErr('')
    try {
      await login(username, password)
      nav('/')
    } catch {
      setErr('Đăng nhập thất bại. Kiểm tra tài khoản và mật khẩu.')
    }
  }

  return (
    <div className="card narrow">
      <h1>Đăng nhập</h1>
      <form onSubmit={onSubmit}>
        {state?.ok && <p className="ok">{state.ok}</p>}
        {err && <p className="error">{err}</p>}
        <label>
          Tên đăng nhập
          <input value={username} onChange={(e) => setUsername(e.target.value)} required />
        </label>
        <label>
          Mật khẩu
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </label>
        <button type="submit">Đăng nhập</button>
      </form>
      <p className="muted">
        Chưa có tài khoản? <Link to="/register">Đăng ký</Link>
      </p>
    </div>
  )
}
