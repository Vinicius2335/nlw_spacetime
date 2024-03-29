import { Copyright } from '@/components/Copyright'
import { Hero } from '@/components/Hero'
import { Profile } from '@/components/Profile'
import { SignIn } from '@/components/SignIn'
import { cookies } from 'next/headers'
export default function SpacetimeLayout({
  children,
}: {
  children: React.ReactNode
}) {
  // se o token existe dentro de cookies, significa que o usuário está autenticado
  const isAuthenticated = cookies().has('token')

  return (
    <main className="grid min-h-screen grid-cols-2">
      {/* Esquerda */}
      <div className="relative flex flex-col items-start justify-between overflow-hidden border-r border-white/10 bg-[url(../assets/bg-stars.svg)] px-28 py-16">
        {/* Blur */}
        <div className="absolute right-0 top-1/2 h-[288px] w-[526px] -translate-y-1/2 translate-x-1/2 rounded-full bg-purple-700 opacity-50 blur-full" />

        {/* Stripes */}
        <div className="absolute bottom-0 right-1 top-0 w-2 bg-stripes" />

        {isAuthenticated ? <Profile /> : <SignIn />}

        <Hero />

        <Copyright />
      </div>

      {/* Direita */}
      <div className="flex max-h-screen flex-col overflow-y-scroll bg-[url(../assets/bg-stars.svg)] bg-cover">
        {children}
      </div>
    </main>
  )
}
