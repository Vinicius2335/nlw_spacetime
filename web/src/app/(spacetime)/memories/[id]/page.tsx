import { api } from '@/lib/api'
import { cookies } from 'next/headers'
import { Memory } from '../../page'
import Image from 'next/image'
import dayjs from 'dayjs'
import ptBr from 'dayjs/locale/pt-br'

interface MemoryDetatilsProps {
  params: {
    id: string
  }
}

dayjs.locale(ptBr)

export default async function MemoryDetails({ params }: MemoryDetatilsProps) {
  const token = cookies().get('token')?.value

  const response = await api.get(`/memories/${params.id}`, {
    headers: { Authorization: `Bearer ${token}` },
  })

  const memory: Memory = response.data

  return (
    <div className="flex flex-col gap-10 p-8">
      <h1>{dayjs(memory.createdAt).format('D[ de ]MMMM[, ]YYYY')}</h1>
      <h2>Content: {memory.content}</h2>
      <Image
        src={`http://localhost:8080${memory.coverUrl}`}
        width={592}
        height={280}
        alt=""
        className="aspect-video w-full rounded-lg object-cover"
      />

      <h2>É publica ? {memory.public ? 'Sim' : 'Não'}</h2>
    </div>
  )
}
