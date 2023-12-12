import { NextRequest, NextResponse } from 'next/server'

// middleware -> quando queremos interceptar o acesso do usuário à alguma determinada rota/endereço
export function middleware(request: NextRequest) {
  const token = request.cookies.get('token')?.value

  // caso o usuário não esteja logado, redireciona para a página de login
  if (!token) {
    return NextResponse.redirect(new URL('/login', request.url))
  }

  // caso o usuário esteja logado não faz nada, segue a vida
  return NextResponse.next()
}

// quais endereços da aplicação queremos obrigar que o usuário deva estar logado
export const config = {
  matcher: '/memories/:path*',
}
