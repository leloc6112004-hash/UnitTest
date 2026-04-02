export default function GuestLayout({ children }) {
  return (
    <div className="guest-shell">
      <div className="guest-shell__inner">{children}</div>
    </div>
  )
}
