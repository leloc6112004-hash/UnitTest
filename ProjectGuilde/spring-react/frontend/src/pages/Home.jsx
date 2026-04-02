import { useAuth } from '../context/AuthContext'

export default function Home() {
  const { user, role } = useAuth()

  return (
    <div className="card admin-card">
      <h1>Xin chào, {user?.username}</h1>
      <p className="muted">
        Vai trò profile: <strong>{role || '—'}</strong>
      </p>
      <p className="muted admin-card__hint">
        Dùng sidebar bên trái để mở Tổng quan, Tài khoản &amp; profile hoặc Người dùng (nếu được phân
        quyền).
      </p>
    </div>
  )
}
