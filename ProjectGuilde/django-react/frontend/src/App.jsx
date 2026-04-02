import { Navigate, Route, Routes, useLocation } from 'react-router-dom'
import { useAuth } from './context/AuthContext'
import AdminLayout from './layouts/AdminLayout'
import GuestLayout from './layouts/GuestLayout'
import Home from './pages/Home'
import Login from './pages/Login'
import ProfilePage from './pages/ProfilePage'
import Register from './pages/Register'
import UsersPage from './pages/UsersPage'

function PrivateRoute({ children }) {
  const { user, loading } = useAuth()
  const loc = useLocation()
  if (loading) return <p className="center muted">Đang tải…</p>
  if (!user) return <Navigate to="/login" replace state={{ from: loc }} />
  return children
}

function GuestRoute({ children }) {
  const { user, loading } = useAuth()
  if (loading) return <p className="center muted">Đang tải…</p>
  if (user) return <Navigate to="/" replace />
  return children
}

export default function App() {
  return (
    <div className="app">
      <Routes>
        <Route
          path="/login"
          element={
            <GuestRoute>
              <GuestLayout>
                <Login />
              </GuestLayout>
            </GuestRoute>
          }
        />
        <Route
          path="/register"
          element={
            <GuestRoute>
              <GuestLayout>
                <Register />
              </GuestLayout>
            </GuestRoute>
          }
        />
        <Route
          path="/"
          element={
            <PrivateRoute>
              <AdminLayout />
            </PrivateRoute>
          }
        >
          <Route index element={<Home />} />
          <Route path="profile" element={<ProfilePage />} />
          <Route path="users" element={<UsersPage />} />
        </Route>
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </div>
  )
}
