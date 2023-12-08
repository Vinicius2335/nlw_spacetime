import { styled } from 'nativewind'
import { ImageBackground, TouchableOpacity, View, Text } from 'react-native'
import blurBg from '../assets/bg-blur.png'
import Stripes from '../assets/stripes.svg'
import Logo from '../assets/nlw-spacetime-logo.svg'

// NativeWind só funciona em componentes nativos do react-native
// precisamos fazer isso
const StyledStripes = styled(Stripes)
// permite utilizar o tailwind no componente Stripes que criamos a partir de um svg

export function Home() {
  return (
    <View className="flex-1">
      <ImageBackground
        source={blurBg}
        className="bg-gray-900 flex-1 px-8 py-10 items-center relative"
        imageStyle={{ position: 'absolute', left: '-100%' }}
      >
        <StyledStripes className="absolute left-2" />
        {/* <Text className='text-gray-50'>RocketSeat</Text> */}

        {/* SignIn */}
        <TouchableOpacity
          activeOpacity={0.7}
          className="mt-4 px-5 py-2 items-center bg-purple-500 rounded-lg"
        >
          <Text className="text-green-50 text-lg text-center leading-snug">
            Crie sua conta e salve suas memórias!
          </Text>
        </TouchableOpacity>

        {/* Hero */}
        <View className="flex-1  items-center justify-center gap-6">
          <Logo />

          <View className="space-y-2">
            <Text className="text-center font-title text-2xl leading-tight text-gray-50">
              Sua cápsula do tempo
            </Text>
            <Text className="text-center font-body text-base leading-relaxed text-gray-100">
              Colecione momentos marcantes da sua jornada e compartilhe (se
              quiser) com o mundo!
            </Text>
          </View>

          <TouchableOpacity
            activeOpacity={0.7}
            className="rounded-full bg-green-500 px-5 py-2"
          >
            <Text className="font-alt text-sm uppercase text-black">
              Cadastrar Lembrança
            </Text>
          </TouchableOpacity>
        </View>

        {/* Copyright */}
        <Text className="text-center font-body text-sm leading-relaxed text-gray-200">
          Feito por 👽 Vinicius Vieira 👽
        </Text>
      </ImageBackground>
    </View>
  )
}
