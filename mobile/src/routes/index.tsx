import { NavigationContainer } from '@react-navigation/native'
import { View } from 'react-native'
import { AppRoutes } from './app.routes'

export function Routes() {
  return (
    // bg-gray-900 -> por causa da transiçao de uma tela pra outra, nao aparecer um fundo branco
    <View className="flex-1 bg-gray-900">
      <NavigationContainer>
        <AppRoutes />
      </NavigationContainer>
    </View>
  )
}
