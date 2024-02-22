# Bash

- `npx create-next-app@latest web --use-pnpm`
- `pnpm add -D @rocketseat/eslint-config` - eslint da rocketseat
- `pnpm uninstall <dependencia>`
- `pnpm add -D prettier prettier-plugin-tailwindcss` - ordena as classes do tailwind numa ordem semantica
  - criar o arquivo prettier.config.js 
- `pnpm add lucide-react`
- `pnpm add cookies-next` -> para utilizar os cookies no client componente já que o cookies() do next/headers só funciona no server componente
- `pnpm add jwt-decode` -> para decodificar as claims dentro do JWT Token
  - criar o arquivo lib/auth.ts
- `pnpm add -D @tailwindcss/forms`
  - em tailwind.config.ts -> plugin -> require('@tailwindcss/forms'),
- `pnpm i @radix-ui/react-dialog`

