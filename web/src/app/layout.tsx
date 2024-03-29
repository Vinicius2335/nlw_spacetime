/* eslint-disable camelcase */
import type { Metadata } from 'next'
import { Bai_Jamjuree, Roboto_Flex } from 'next/font/google'
import './globals.css'

// Roboto_Flex se adapta ao font-bold
const roboto = Roboto_Flex({ subsets: ['latin'], variable: '--font-roboto' })
// Jamjuree precissamos passar o peso da fonte que usaremos
const jamjuree = Bai_Jamjuree({
  subsets: ['latin'],
  weight: '700',
  variable: '--font-jamjuree',
})

export const metadata: Metadata = {
  title: 'Nlw Spacetime',
  description:
    'Uma cápsula do tempo construida com React, Next.js, TailwindCSS e Typescript.',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="pt-BR" data-lt-installed="true">
      <body
        className={`${roboto.variable} ${jamjuree.variable} bg-gray-900 font-sans text-gray-100 antialiased`}
      >
        {children}
      </body>
    </html>
  )
}
