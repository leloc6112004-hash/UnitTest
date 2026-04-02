import { useState } from 'react'
import { NavLink, Outlet, useLocation } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

function useAdminPageTitle() {
  const { pathname } = useLocation()
  if (pathname === '/') return 'Tổng quan'
  if (pathname.startsWith('/profile')) return 'Tài khoản & profile'
  if (pathname.startsWith('/users')) return 'Người dùng'
  return 'Bảng điều khiển'
}

function IconHome() {
  return (
    <svg className="admin-nav__svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" aria-hidden>
      <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z" />
      <polyline points="9 22 9 12 15 12 15 22" />
    </svg>
  )
}

function IconUser() {
  return (
    <svg className="admin-nav__svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" aria-hidden>
      <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" />
      <circle cx="12" cy="7" r="4" />
    </svg>
  )
}

function IconUsers() {
  return (
    <svg className="admin-nav__svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" aria-hidden>
      <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2" />
      <circle cx="9" cy="7" r="4" />
      <path d="M23 21v-2a4 4 0 0 0-3-3.87" />
      <path d="M16 3.13a4 4 0 0 1 0 7.75" />
    </svg>
  )
}

function navClass({ isActive }) {
  return 'admin-nav__link' + (isActive ? ' admin-nav__link--active' : '')
}

export default function AdminLayout() {
  const { user, role, logout } = useAuth()
  const pageTitle = useAdminPageTitle()
  const canSeeUsers = role === 'moderator' || role === 'admin'
  const [mobileOpen, setMobileOpen] = useState(false)

  return (
    <div className="admin-shell">
      <button
        type="button"
        className="admin-sidebar__toggle"
        aria-expanded={mobileOpen}
        aria-label="Mở menu"
        onClick={() => setMobileOpen((o) => !o)}
      >
        <span className="admin-sidebar__toggle-bar" />
        <span className="admin-sidebar__toggle-bar" />
        <span className="admin-sidebar__toggle-bar" />
      </button>
      {mobileOpen && (
        <button
          type="button"
          className="admin-sidebar__backdrop"
          aria-label="Đóng menu"
          onClick={() => setMobileOpen(false)}
        />
      )}
      <aside className={'admin-sidebar' + (mobileOpen ? ' admin-sidebar--open' : '')}>
        <div className="admin-sidebar__head">
          <span className="admin-sidebar__logo">SB</span>
          <div>
            <div className="admin-sidebar__title">Admin</div>
            <div className="admin-sidebar__subtitle">Spring Boot + React</div>
          </div>
        </div>

        <p className="admin-sidebar__section-label">Điều hướng</p>
        <nav className="admin-nav" onClick={() => setMobileOpen(false)}>
          <NavLink to="/" end className={navClass}>
            <IconHome />
            Tổng quan
          </NavLink>
          <NavLink to="/profile" className={navClass}>
            <IconUser />
            Tài khoản &amp; profile
          </NavLink>
          {canSeeUsers && (
            <NavLink to="/users" className={navClass}>
              <IconUsers />
              Người dùng
            </NavLink>
          )}
        </nav>

        <div className="admin-sidebar__footer">
          <div className="admin-sidebar__user">
            <span className="admin-sidebar__avatar" aria-hidden>
              {(user?.username || '?').slice(0, 1).toUpperCase()}
            </span>
            <div className="admin-sidebar__user-meta">
              <span className="admin-sidebar__user-name">{user?.username}</span>
              <span className="admin-sidebar__user-role">{role || 'user'}</span>
            </div>
          </div>
          <button type="button" className="admin-sidebar__logout" onClick={logout}>
            Đăng xuất
          </button>
        </div>
      </aside>

      <div className="admin-main">
        <header className="admin-topbar">
          <h1 className="admin-topbar__heading">{pageTitle}</h1>
        </header>
        <div className="admin-content">
          <Outlet />
        </div>
      </div>
    </div>
  )
}
