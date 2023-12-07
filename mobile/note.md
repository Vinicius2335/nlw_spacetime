# Bash

- `npx create-expo-app mobile`
  - renomear App.js -> App.tsx
  - npm expo start
  - npx expo start --clear (limpar o cache)
- `npm i nativewind` - NativeWind - tailwindcss para react native
  - `npm i tailwindcss -D`
  - `npx tailwindcss init`
  - tailwind.config.js -> `content: ["./App.tsx", "./app/**/*.tsx"],`
  - babel.config.js -> `plugins: ["nativewind/babel"],`
  - tsconfig.json -> `"compilerOptions": {"types": ["nativewind/types"]},`
- `npm i @rocketseat/eslint-config -D`
  - criar o arquivo .eslintrc.json
- `npm i prettier-plugin-tailwindcss -D`
  - criar o arquivo prettier.config.js
- `npx expo install expo-font @expo-google-fonts/roboto @expo-google-fonts/bai-jamjuree`
- `npm i -D react-native-svg-transformer` - biblioteca para suportar svg
  - criar o arquivo metro.config.js
  - adicionar a pasta @types
  - configurar types para svg
  - configurar typeps para png


# Erros

- **error:** App.tsx: F:\Usuario\Documents\web\nlw_projects\nlw12_spacetime\mobile\App.tsx: Use process(css).then(cb) to work with async plugins
- erro na versao do tailwind(3.3.6) com o react-native na versao maior que 3.3.2
- **soluçao:** - `npm uninstall tailwindcss` -> `npm i -D tailwindcss@3.3.2`