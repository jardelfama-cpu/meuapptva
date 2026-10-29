# MeuAppTV
"App de streaming para TV"

## Descrição
Aplicativo Android para reprodução de canais e conteúdo em TV, com lista de canais e player de vídeo integrado.

## Funcionalidades
- Lista de canais em tela principal
- Reprodutor de vídeo
- Suporte a playlists M3U
- Layout pensado para TV e controle remoto
- Navegação por seleção de canal

## Canais de exemplo
- TV Globo
- SBT
- Record
- Band
- RedeTV!
- Cultura
- Discovery
- Cartoon Network

## Tecnologias
- Kotlin
- Android
- ExoPlayer / Media3
- ListView
- Android Studio

## Como usar
1. Configure o arquivo M3U com os canais desejados.
2. Ajuste o URL da playlist no `MainActivity`.
3. Execute o app em emulador ou TV Android.
4. Selecione o canal na lista para reproduzir.

## Estrutura do projeto
- `app/src/main/java/com/jardelfama/meuapptva/MainActivity.kt` — lógica principal do app
- `app/src/main/res/layout/activity_main.xml` — layout da tela principal
- `app/build.gradle.kts` — dependências do projeto

## Observa��ões
Este projeto está em desenvolvimento e pode ser expandido com:
- logos dos canais
- EPG
- tela de detalhes do canal
- foco de TV e navegação por controle remoto
- player em tela cheia

## Requisitos
- Android Studio
- SDK Android 34
- Java/Kotlin
- Internet para carregar a lista de canais e streams
