import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

export default function Register() {
  const { register } = useAuth()
  const nav = useNavigate()
  const [form, setForm] = useState({
    username: '',
    email: '',
    password: '',
    password_confirm: '',
    first_name: '',
    last_name: '',
  })
  const [err, setErr] = useState(null)

  function set(k, v) {
    setForm((f) => ({ ...f, [k]: v }))
  }

  async function onSubmit(e) {
    e.preventDefault()
    setErr(null)
    try {
      await register(form)
      nav('/login', { state: { ok: 'Đăng ký thành công. Hãy đăng nhập.' } })
    } catch (ex) {
      const d = ex.response?.data
      setErr(typeof d === 'object' ? JSON.stringify(d) : 'Đăng ký thất bại.')
    }
  }

  return (
    <div className="card narrow">
      <h1>Đăng ký</h1>
      <form onSubmit={onSubmit}>
        {err && <p className="error">{err}</p>}
        <label>
          Tên đăng nhập
          <input value={form.username} onChange={(e) => set('username', e.target.value)} required />
        </label>
        <label>
          Email
          <input type="email" value={form.email} onChange={(e) => set('email', e.target.value)} />
        </label>
        <label>
          Họ
          <input value={form.last_name} onChange={(e) => set('last_name', e.target.value)} />
        </label>
        <label>
          Tên
          <input value={form.first_name} onChange={(e) => set('first_name', e.target.value)} />
        </label>
        <label>
          Mật khẩu
          <input
            type="password"
            value={form.password}
            onChange={(e) => set('password', e.target.value)}
            required
          />
        </label>
        <label>
          Xác nhận mật khẩu
          <input
            type="password"
            value={form.password_confirm}
            onChange={(e) => set('password_confirm', e.target.value)}
            required
          />
        </label>
        <button type="submit">Tạo tài khoản</button>
      </form>
      <p className="muted">
        Đã có tài khoản? <Link to="/login">Đăng nhập</Link>
      </p>
    </div>
  )
}
