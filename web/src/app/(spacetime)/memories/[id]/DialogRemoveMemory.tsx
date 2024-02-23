'use client'

import { api } from '@/lib/api'
import { setAuthHeader } from '@/utils/AuthUtil'
import * as Dialog from '@radix-ui/react-dialog'
import { X } from 'lucide-react'
import { useRouter } from 'next/navigation'
import { toast } from 'sonner'

interface DialogRemoveMemoryProps {
  idMemory: string
}

export function DialogRemoveMemory({ idMemory }: DialogRemoveMemoryProps) {
  const router = useRouter()

  async function handleOnConfirm() {
    try {
      setAuthHeader()
      await api.delete(`/memories/${idMemory}`)

      toast.success('Memória removida com sucesso...')
      await new Promise((resolve) => setTimeout(resolve, 1000))

      router.push('/')
      router.refresh()
    } catch (ex) {
      console.error(ex)
      toast.error(
        'Erro ao tentar remover memória, tente novamente mais tarde...',
      )
    }
  }

  return (
    <Dialog.Root>
      <Dialog.Trigger asChild>
        <button className="flex items-center justify-center gap-1 rounded-md bg-red-500 px-2 py-1.5 text-sm text-zinc-100 transition duration-300 ease-in-out hover:scale-110 hover:bg-red-600">
          <X className="h-4 w-4" />
          Remover
        </button>
      </Dialog.Trigger>

      <Dialog.Portal>
        <Dialog.Overlay className="fixed inset-0 bg-black/70" />
        <Dialog.Content className="fixed left-1/2 top-1/2 w-[500px] -translate-x-1/2 -translate-y-1/2 space-y-6 rounded-lg bg-zinc-950 px-10 py-8 text-white shadow-lg shadow-black/25">
          <Dialog.Title className="text-3xl font-black text-white">
            Remover Memória
          </Dialog.Title>

          <Dialog.Description className="text-lg text-zinc-400">
            Tem certeza que deseja remover esta memória ?
          </Dialog.Description>

          <div className="flex items-center justify-center gap-2">
            <Dialog.Close asChild>
              <button className="flex items-center justify-center gap-1 rounded-md bg-zinc-100 px-2 py-1.5 text-sm text-zinc-800 transition duration-300 ease-in-out hover:scale-110 hover:bg-zinc-300">
                Cancelar
              </button>
            </Dialog.Close>
            <button
              className="flex items-center justify-center gap-1 rounded-md bg-red-500 px-2 py-1.5 text-sm text-zinc-100 transition duration-300 ease-in-out hover:scale-110 hover:bg-red-600"
              onClick={handleOnConfirm}
            >
              Confirmar
            </button>
          </div>
        </Dialog.Content>
      </Dialog.Portal>
    </Dialog.Root>
  )
}
