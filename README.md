<h1 align="center"> GitPoint </h1> <br>
<p align="center">
  <a href="https://gitpoint.co/">
    <img alt="Inmolab" title="Inmolab" src="http://i.imgur.com/c0efZMp.png" width="450">
  </a>
</p>

<p align="center">
  GitHub en tu bolsillo. Construido con Spring.
</p>

<p align="center">
  <a href="https://google.com">
    <img alt="Descargar en la App Store" title="App Store" src="http://i.imgur.com/0n2zqHD.png" width="140">
  </a>

  <a href="https://google.com">
    <img alt="Consíguelo en Google Play" title="Google Play" src="http://i.imgur.com/mtGRPuM.png" width="140">
  </a>
</p>

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
## Tabla de Contenidos

- [Introducción](#introduction)
- [Características](#features)
- [Comentarios](#feedback)
- [Contribuidores](#contributors)
- [Proceso de Construcción](#build-process)
- [NimoCoders](#nimocoders-)
- [Patrocinadores](#sponsors-)
- [Agradecimientos](#acknowledgments)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Introducción

[![Build Status](https://img.shields.io/travis/gitpoint/git-point.svg?style=flat-square)](https://travis-ci.org/gitpoint/git-point)
[![Coveralls](https://img.shields.io/coveralls/github/gitpoint/git-point.svg?style=flat-square)](https://coveralls.io/github/gitpoint/git-point)
[![All Contributors](https://img.shields.io/badge/all_contributors-73-orange.svg?style=flat-square)](./CONTRIBUTORS.md)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg?style=flat-square)](http://commitizen.github.io/cz-cli/)
[![Gitter chat](https://img.shields.io/badge/chat-on_gitter-008080.svg?style=flat-square)](https://gitter.im/git-point)

Ver información del repositorio y del usuario, controlar tus notificaciones e incluso gestionar tus problemas y solicitudes de extracción. Construido con React Native, GitPoint es uno de los clientes no oficiales de GitHub con más funciones y es 100% gratuito.

**Disponible tanto para iOS como para Android.**

<p align="center">
  <img src = "http://i.imgur.com/HowF6aM.png" width=350>
</p>

## Características

Algunas de las cosas que puedes hacer con GitPoint:

* Ver el feed de actividad del usuario
* Comunicarte en tus conversaciones de problemas y solicitudes de extracción
* Cerrar o bloquear problemas
* Aplicar etiquetas y asignar responsables
* Revisar y fusionar solicitudes de extracción
* Crear nuevos problemas
* Marcar como favorito, seguir y bifurcar repositorios
* Controlar tus notificaciones no leídas y en las que participas
* Buscar fácilmente cualquier usuario o repositorio

<p align="center">
  <img src = "http://i.imgur.com/IkSnFRL.png" width=700>
</p>

<p align="center">
  <img src = "http://i.imgur.com/0iorG20.png" width=700>
</p>

## Comentarios

Si hay algo de lo que te gustaría hablar, ¡siéntete libre de unirte a nuestro [chat de Gitter](https://gitter.im/git-point)!

## Proceso de Construcción

- Sigue la [Guía de React Native](https://facebook.github.io/react-native/docs/getting-started.html) para comenzar a construir un proyecto con código nativo. **Se requiere un Mac si deseas desarrollar para iOS.**
- Clona o descarga el repositorio
- `yarn` para instalar dependencias
- `yarn run link` para enlazar dependencias de react-native
- `yarn start:ios` para iniciar el empaquetador y ejecutar la aplicación en el simulador de iOS (`yarn start:ios:logger` iniciará la aplicación con [redux-logger](https://github.com/evgenyrodionov/redux-logger))
- `yarn start:android` para iniciar el empaquetador y ejecutar la aplicación en el dispositivo/emulador de Android (`yarn start:android:logger` iniciará la aplicación con [redux-logger](https://github.com/evgenyrodionov/redux-logger))

Por favor, consulta las [directrices de contribución](./CONTRIBUTING.md) para obtener un proceso detallado sobre cómo construir tu aplicación, así como información de resolución de problemas.

**Claves de Desarrollo**: El `CLIENT_ID` y `CLIENT_SECRET` en `api/index.js` son para propósitos de desarrollo y no representan las claves reales de la aplicación. Siéntete libre de usarlas o usar un nuevo conjunto de claves creando una [aplicación OAuth](https://github.com/settings/applications/new) propia. Establece la "URL de callback de autorización" a `gitpoint://welcome`.

## NimoCoders [![NimoCoders en Open Collective](https://opencollective.com/git-point/backers/badge.svg)](#nimocoders)

¡Gracias a todos nuestros NimoCoders! 🙏 [[Conviértete en un NimoCoder](https://opencollective.com/git-point#backer)]

<a href="https://opencollective.com/git-point#backers" target="_blank"><img src="https://opencollective.com/git-point/backers.svg?width=890"></a>

## Patrocinadores [![Patrocinadores en Open Collective](https://opencollective.com/git-point/sponsors/badge.svg)](#sponsors)

Apoya este proyecto convirtiéndote en patrocinador. Tu logo aparecerá aquí con un enlace a tu sitio web. [[Conviértete en patrocinador](https://opencollective.com/git-point#sponsor)]

<a href="https://opencollective.com/git-point/sponsor/0/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/0/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/1/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/1/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/2/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/2/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/3/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/3/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/4/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/4/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/5/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/5/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/6/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/6/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/7/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/7/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/8/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/8/avatar.svg"></a>
<a href="https://opencollective.com/git-point/sponsor/9/website" target="_blank"><img src="https://opencollective.com/git-point/sponsor/9/avatar.svg"></a>

## Agradecimientos

Gracias a [JetBrains](https://www.jetbrains.com) y [Spring](https://www.jetbrains.com) por apoyarnos con una [Licencia de Código Abierto gratuita](https://www.jetbrains.com/buy/opensource).
