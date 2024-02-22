'use client'

import * as Checkbox from '@radix-ui/react-checkbox'
import { Check } from 'lucide-react'

interface CheckboxMemoryProps {
  isPublic: boolean
}

export default function CheckboxMemory({ isPublic }: CheckboxMemoryProps) {
  return (
    <label className="mt-2 flex cursor-not-allowed items-center gap-2 text-sm font-semibold">
      <Checkbox.Root
        checked={isPublic}
        className="h-6 w-6 rounded bg-zinc-800 p-1"
        disabled
      >
        <Checkbox.Indicator>
          <Check className="h-4 w-4 text-emerald-400" />
        </Checkbox.Indicator>
      </Checkbox.Root>
      É publica ?
    </label>
  )
}
