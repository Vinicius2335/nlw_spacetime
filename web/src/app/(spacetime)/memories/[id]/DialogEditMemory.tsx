'use client'

import * as Dialog from '@radix-ui/react-dialog'
import FormEditMemory from './FormEditMemory'
import { Pencil } from 'lucide-react'
import { Memory } from '../../page'

interface DialogEditMemoryProps {
  memory: Memory
}

export default function DialogEditMemory({ memory }: DialogEditMemoryProps) {
  return (
    <Dialog.Root>
      <Dialog.Trigger asChild>
        <button className="flex items-center justify-center gap-2 rounded-md bg-yellow-400 px-2 py-1.5 text-sm text-zinc-800 transition duration-300 ease-in-out hover:scale-110 hover:bg-yellow-500">
          <Pencil className="h-4 w-4" />
          Editar
        </button>
      </Dialog.Trigger>

      <Dialog.Portal>
        <Dialog.Overlay className="fixed inset-0 bg-black/70" />
        <Dialog.Content className="fixed left-1/2 top-1/2 w-[500px] -translate-x-1/2 -translate-y-1/2 rounded-lg bg-zinc-950 px-10 py-8 text-white shadow-lg shadow-black/25">
          <Dialog.Title className="text-3xl font-black text-white">
            Editar Memória
          </Dialog.Title>

          <FormEditMemory memory={memory} />
        </Dialog.Content>
      </Dialog.Portal>
    </Dialog.Root>
  )
}
