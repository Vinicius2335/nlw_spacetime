import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { Home } from '../screens/Home'
import { Login } from '../screens/Login'

const Stack = createNativeStackNavigator()

export function AppRoutes() {
  return (
    // por padrao aparece o header, e essa config retira o header de todos os componentes
    <Stack.Navigator
      initialRouteName="home"
      screenOptions={{ headerShown: false }}
    >
      <Stack.Screen name="home" component={Home} />
      <Stack.Screen name="login" component={Login} />
    </Stack.Navigator>
  )
}
