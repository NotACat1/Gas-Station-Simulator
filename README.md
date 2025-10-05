# ⛽ Gas Station Simulator — симулятор АЗС на Jetpack Compose

> 💡 _Простое, стильное и образовательное Android-приложение, моделирующее работу автозаправочной станции. Создай заказ, рассчитай выручку и подведи итоги смены — всё в духе Material 3._

---

## 🌟 Особенности

✅ Создание заказов — выбери вид топлива и укажи количество литров
💰 Автоматический подсчёт стоимости
📊 Итог смены — количество и выручка по каждому виду топлива
🎨 Material 3 дизайн с адаптацией под тёмную и светлую темы
💡 MVVM-архитектура — чистая логика, минимализм в UI
⚡ Навигация без фрагментов — только Compose

---

## ⚙️ Технологии

<div align="center">

| 💻 Технология                                                                                                                   | 🧩 Назначение                                         |
| :------------------------------------------------------------------------------------------------------------------------------ | :---------------------------------------------------- |
| ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white&style=for-the-badge)                           | Основной язык разработки                              |
| ![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?logo=jetpackcompose&logoColor=white&style=for-the-badge) | Декларативный UI                                      |
| ![Material 3](https://img.shields.io/badge/Material_Design_3-6200EE?logo=materialdesign&logoColor=white&style=for-the-badge)    | Современные компоненты UI                             |
| ![Navigation Compose](https://img.shields.io/badge/Navigation-FF9800?logo=android&logoColor=white&style=for-the-badge)          | Навигация между экранами                              |
| ![ViewModel](https://img.shields.io/badge/ViewModel-009688?logo=android&logoColor=white&style=for-the-badge)                    | Управление состоянием                                 |
| ![Google Fonts](https://img.shields.io/badge/Google_Fonts-4285F4?logo=google&logoColor=white&style=for-the-badge)               | Элегантная типографика                                |
| ![Dynamic Color](https://img.shields.io/badge/Dynamic_Color-03A9F4?logo=android&logoColor=white&style=for-the-badge)            | Поддержка динамической цветовой палитры (Android 12+) |

</div>

---

## 📱 Скриншоты

| Новый заказ                            | Итоги смены                                |
| -------------------------------------- | ------------------------------------------ |
| ![Order Screen](https://github.com/user-attachments/assets/0211934b-e6d0-44f7-a375-29bbd0e1f4c2) | ![Summary Screen](https://github.com/user-attachments/assets/854e1597-3d4c-4d40-80f4-fd8a602b1ae6) |

> _Всё просто, современно и удобно — как должна выглядеть настоящая АЗС._

---

## 🧩 Архитектура

```plaintext
app/
 ├─ MainActivity.kt
 ├─ navigation/
 │   └─ NavGraph.kt
 ├─ ui/screens/
 │   ├─ OrderScreen.kt
 │   └─ SummaryScreen.kt
 ├─ viewmodel/
 │   └─ FuelViewModel.kt
 └─ model/
     └─ FuelType.kt
```

> Основано на **MVVM** + **Jetpack Compose Navigation**
> Никаких фрагментов, только чистый Compose-код ❤️

---

## 🚀 Запуск проекта

```bash
# 1. Клонируй репозиторий
git clone https://github.com/NotACat1/Gas-Station-Simulator.git

# 2. Открой проект в Android Studio (Arctic Fox или выше)

# 3. Установи зависимости и запусти
```

> Требуется Android SDK 33+ и Kotlin 1.9+

---

## 🧠 Образовательная цель

Проект создан, чтобы продемонстрировать:

- создание интерфейсов в **Jetpack Compose**
- архитектуру **MVVM** с ViewModel и состоянием
- применение **Material 3**
- работу с **Navigation Compose**
- практику работы с состояниями (`remember`, `mutableStateOf`, `collectAsState`)
