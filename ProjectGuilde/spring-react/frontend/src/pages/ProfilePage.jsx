import { useEffect, useState } from 'react'
import { api } from '../api/client'
import { useAuth } from '../context/AuthContext'

export default function ProfilePage() {
  const { refreshUser } = useAuth()
  const [profile, setProfile] = useState(null)
  const [account, setAccount] = useState({
    email: '',
    first_name: '',
    last_name: '',
  })
  const [profileForm, setProfileForm] = useState({})
  const [accountMsg, setAccountMsg] = useState('')
  const [profileMsg, setProfileMsg] = useState('')
  const [errAccount, setErrAccount] = useState('')
  const [errProfile, setErrProfile] = useState('')

  useEffect(() => {
    api.get('/me/').then(({ data }) => {
      setAccount({
        email: data.email || '',
        first_name: data.first_name || '',
        last_name: data.last_name || '',
      })
      const p = data.profile
      setProfile(p)
      setProfileForm({
        display_name: p?.display_name || '',
        phone: p?.phone || '',
        bio: p?.bio || '',
        avatar_url: p?.avatar_url || '',
      })
    })
  }, [])

  async function saveAccount(e) {
    e.preventDefault()
    setErrAccount('')
    setAccountMsg('')
    try {
      await api.patch('/me/', account)
      await refreshUser()
      setAccountMsg('Đã lưu thông tin tài khoản (User).')
    } catch {
      setErrAccount('Không lưu được tài khoản.')
    }
  }

  async function saveProfile(e) {
    e.preventDefault()
    setErrProfile('')
    setProfileMsg('')
    try {
      const { data } = await api.patch('/me/profile/', profileForm)
      setProfile(data)
      await refreshUser()
      setProfileMsg('Đã lưu profile.')
    } catch {
      setErrProfile('Không lưu được profile.')
    }
  }

  if (!profile) return <p>Đang tải…</p>

  return (
    <div className="card admin-card">
      <h1>Tài khoản &amp; Profile</h1>
      <p className="muted">
        User: <code>{profile.username}</code> — role: <strong>{profile.role}</strong>
      </p>

      <h2 className="section-title">Bảng User — PATCH /api/me/</h2>
      <form onSubmit={saveAccount} className="stacked-form">
        {accountMsg && <p className="ok">{accountMsg}</p>}
        {errAccount && <p className="error">{errAccount}</p>}
        <label>
          Email
          <input
            type="email"
            value={account.email}
            onChange={(e) => setAccount((a) => ({ ...a, email: e.target.value }))}
          />
        </label>
        <label>
          Tên
          <input
            value={account.first_name}
            onChange={(e) => setAccount((a) => ({ ...a, first_name: e.target.value }))}
          />
        </label>
        <label>
          Họ
          <input
            value={account.last_name}
            onChange={(e) => setAccount((a) => ({ ...a, last_name: e.target.value }))}
          />
        </label>
        <button type="submit">Lưu tài khoản</button>
      </form>

      <h2 className="section-title">Bảng Profile — PATCH /api/me/profile/</h2>
      <form onSubmit={saveProfile} className="stacked-form">
        {profileMsg && <p className="ok">{profileMsg}</p>}
        {errProfile && <p className="error">{errProfile}</p>}
        <label>
          Tên hiển thị
          <input
            value={profileForm.display_name}
            onChange={(e) =>
              setProfileForm((f) => ({ ...f, display_name: e.target.value }))
            }
          />
        </label>
        <label>
          Điện thoại
          <input
            value={profileForm.phone}
            onChange={(e) => setProfileForm((f) => ({ ...f, phone: e.target.value }))}
          />
        </label>
        <label>
          Giới thiệu
          <textarea
            rows={4}
            value={profileForm.bio}
            onChange={(e) => setProfileForm((f) => ({ ...f, bio: e.target.value }))}
          />
        </label>
        <label>
          URL ảnh đại diện
          <input
            value={profileForm.avatar_url}
            onChange={(e) =>
              setProfileForm((f) => ({ ...f, avatar_url: e.target.value }))
            }
          />
        </label>
        <button type="submit">Lưu profile</button>
      </form>
    </div>
  )
}
