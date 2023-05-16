import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";

export default function App() {
  return (
    <View className="flex-1 items-center justify-center bg-gray-950">
      <StatusBar style="light" translucent />
      <Text className="text-xl font-bold text-zinc-50">
        Open up App.tsx to start working on your app!
      </Text>
    </View>
  );
}
