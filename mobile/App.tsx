import { StatusBar } from 'expo-status-bar';
import { Text, ImageBackground, View, TouchableOpacity } from 'react-native';
import { useFonts, Roboto_400Regular, Roboto_700Bold } from "@expo-google-fonts/roboto"
import { BaiJamjuree_700Bold } from "@expo-google-fonts/bai-jamjuree"
import blurBg from "./src/assets/bg-blur.png"
import Stripes from "./src/assets/stripes.svg"
import Logo from "./src/assets/nlw-spacetime-logo.svg"
import { styled } from 'nativewind';
// TODO svg vira um componente
// NativeWind só funciona em componentes nativos do react-native
// precisamos fazer isso

const StyledStripes = styled(Stripes)
// permite utilizar o tailwind no componente Stripes que criamos a partir de um svg

export default function App() {
  const [hasLoadedFonts] = useFonts({
    Roboto_400Regular, Roboto_700Bold, BaiJamjuree_700Bold
  })

  if (!hasLoadedFonts) {
    return null;
  }

  return (
    <ImageBackground
      source={blurBg}
      className='bg-gray-900 flex-1 px-8 py-10 items-center relative'
      imageStyle={{ position: 'absolute', left: '-100%' }}
    >

      <StyledStripes className='absolute left-2' />
      {/* <Text className='text-gray-50'>RocketSeat</Text> */}

      <View className='flex-1  items-center justify-center gap-6'>
        <Logo />

        <View className='space-y-2'>
          <Text className='text-center font-title text-2xl leading-tight text-gray-50'>Sua cápsula do tempo</Text>
          <Text className='text-center font-body text-base leading-relaxed text-gray-100'>
            Colecione momentos marcantes da sua jornada e compartilhe (se quiser)
            com o mundo!
          </Text>
        </View>

        <TouchableOpacity activeOpacity={0.7} className='rounded-full bg-green-500 px-5 py-2'>
          <Text className='font-alt text-sm uppercase text-black'>Cadastrar Lembrança</Text>
        </TouchableOpacity>
      </View>

      <Text className='text-center font-body text-sm leading-relaxed text-gray-200'>Feito por 👽 Vinicius Vieira 👽</Text>

      <StatusBar style="light" translucent />
    </ImageBackground>
  );
}
