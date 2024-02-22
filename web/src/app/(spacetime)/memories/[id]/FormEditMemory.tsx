import { Check, X } from 'lucide-react'
import { FormEvent, useState } from 'react'
import * as Dialog from '@radix-ui/react-dialog'
import * as Checkbox from '@radix-ui/react-checkbox'
import { Memory } from '../../page'
import { setAuthHeader } from '@/utils/AuthUtil'
import { api } from '@/lib/api'
import { toast } from 'sonner'
import { useRouter } from 'next/navigation'

interface FormEditMemoryProps {
  memory: Memory
}

export default function FormEditMemory({ memory }: FormEditMemoryProps) {
  const [isVisible, setIsVisible] = useState(memory.public)
  const [content, setContent] = useState(memory.content)

  const router = useRouter()

  async function handleOnSubmit(event: FormEvent) {
    event.preventDefault()

    try {
      setAuthHeader()
      const visibility = isVisible === true ? 'true' : 'false'

      await api
        .put(`/memories/${memory.id}`, {
          coverUrl: memory.coverUrl,
          content,
          isPublic: visibility,
        })
        .then((resp) => resp.data)

      toast.success('Memória atualizada com sucesso...')
      await new Promise((resolve) => setTimeout(resolve, 1000))

      router.push('/')
      router.refresh()
    } catch (ex) {
      console.error(ex)
      toast.error(
        'Erro ao tentar atualizar a memória, tente novamente mais tarde.',
      )
    }
  }

  function handleOnChecked(checked: boolean) {
    if (checked === true) {
      setIsVisible(true)
    } else {
      setIsVisible(false)
    }
  }

  return (
    <form className="mt-8 w-full space-y-6" onSubmit={handleOnSubmit}>
      <div className="space-y-2">
        <label className="block text-sm font-medium">Descrição</label>

        <textarea
          name="content"
          spellCheck={false}
          className="scrollbar-thin scrollbar-track-transparent scrollbar-thumb-gray-100 scrollbar-track-rounded-full scrollbar-thumb-rounded-full h-44 w-full flex-1 resize-none overflow-y-auto rounded border-0 bg-transparent p-0 text-lg leading-relaxed text-gray-100 placeholder:text-gray-400 focus:ring-0"
          placeholder="Relatos sobre essa experiência que você quer lembrar para sempre."
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
      </div>

      <label className="mt-2 flex cursor-pointer items-center gap-2 text-sm font-semibold">
        <Checkbox.Root
          checked={isVisible}
          onCheckedChange={(checked: boolean) => handleOnChecked(checked)}
          className="h-6 w-6 rounded bg-zinc-900 p-1"
        >
          <Checkbox.Indicator>
            <Check className="h-4 w-4 text-emerald-400" />
          </Checkbox.Indicator>
        </Checkbox.Root>
        Memória pode ser pública?
      </label>

      <div className="flex items-center justify-end gap-2">
        <Dialog.Close asChild>
          <button className="flex items-center justify-center gap-1 rounded-md bg-red-500 px-2 py-2 text-sm text-zinc-100  transition duration-300 ease-in-out hover:scale-110 hover:bg-red-600">
            <X className="h-4 w-4" />
            Cancelar
          </button>
        </Dialog.Close>

        <button
          type="submit"
          className="flex items-center justify-center gap-1 rounded-md bg-green-500 px-2 py-2 font-alt text-sm  text-black transition duration-300 ease-in-out hover:scale-110 hover:bg-green-700"
        >
          <Check className="h-4 w-4" />
          Salvar
        </button>
      </div>
    </form>
  )
}
