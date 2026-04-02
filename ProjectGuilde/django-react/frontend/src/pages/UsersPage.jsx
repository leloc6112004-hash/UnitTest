import { useEffect, useState } from 'react'
import { api } from '../api/client'
import { useAuth } from '../context/AuthContext'

export default function UsersPage() {
  const { role } = useAuth()
  const [users, setUsers] = useState([])
  const [err, setErr] = useState('')
  const isAdmin = role === 'admin'

  useEffect(() => {
    api
      .get('/users/')
      .then(({ data }) => setUsers(data.results ?? data))
      .catch(() => setErr('Không có quyền xem danh sách (cần moderator hoặc admin).'))
  }, [])

  async function changeRole(userId, newRole) {
    try {
      await api.patch(`/users/${userId}/set-role/`, { role: newRole })
      const { data } = await api.get('/users/')
      setUsers(data.results ?? data)
    } catch {
      setErr('Không đổi được role (cần admin).')
    }
  }

  if (err && !users.length) {
    return (
      <div className="card admin-card admin-card--wide">
        <p className="error">{err}</p>
      </div>
    )
  }

  return (
    <div className="card admin-card admin-card--wide">
      <h1>Danh sách User + Profile</h1>
      {err && <p className="error">{err}</p>}
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role (profile)</th>
            {isAdmin && <th>Đổi role</th>}
          </tr>
        </thead>
        <tbody>
          {users.map((u) => (
            <tr key={u.id}>
              <td>{u.id}</td>
              <td>{u.username}</td>
              <td>{u.email}</td>
              <td>{u.profile?.role}</td>
              {isAdmin && (
                <td>
                  <select
                    value={u.profile?.role || 'user'}
                    onChange={(e) => changeRole(u.id, e.target.value)}
                  >
                    <option value="user">user</option>
                    <option value="moderator">moderator</option>
                    <option value="admin">admin</option>
                  </select>
                </td>
              )}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
