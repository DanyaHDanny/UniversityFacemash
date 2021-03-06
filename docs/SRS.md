﻿# Требования к проекту
---
# Содержание

# 1 Введение

## 1.1 Назначение

 В этом документе описаны функциональные и нефункциональные требования к Web-приложению “University Facemash”. Этот документ предназначен для команды, которая будет реализовывать и проверять корректность работы приложения.

## 1.2 Бизнес-требования


### 1.2.1 Исходные данные

В современном мире много людей работает с различного рода вычислениями.Однако, не все калькуляторы имеют возможность выполнять логические операции. Это приводит к тому, что пользователи ищут сторонние сервисы для получение желаемого результата. 


### 1.2.2 Возможности бизнеса

Многие студенты и преподователи желают иметь возможностб иметь систему для лёгкого взаимодействия между собой.
Подобное Web-приложение позволит преподавателям проще контролировать упеваемость студентов, упростить систему выдачи лабораторных работ минуя 'кучи' Google-дисков и прочих атрибутов современного обучения.
Студентам будет проще узнать задание для лаботраторной работы,а так же оценнки выставленные им. 

# 2 Требования пользователя

### Классы пользвателей

| Класс пользователей | Описание |
|:---|:---|
| Студент | Пользователи, которые могут просматривать оценки, профили, а так же выставлять оценки и ставить к ним комментарии. |
| Преподаватель | Пользователи, которые могут просматривать оценки и профили. |
| Администратор | Супер администратор. |

### Программные интерфейсы

#####  Позволяет студентам:
- Входить и выходить из своей учётной записи
- Изменять свой пароль, если он был забыт
- Оставлять комментарий под своей оценкой, фидбеком или лабороторной работой
- Просматривать профили студентов, преподователей и своей группы, их статистики и контакты

##### Позволяет преподавателям:
 - Входить и выходить из своей учётной записи
 - Изменять свой пароль, если он был забыт
 - Поиск групп, студентов или преподователей, использую поисковую систему
 - Ставить оценки и оставлять комментарии к работам студентов
 - Отслеживать успеваемость студентов
 - Просматривать профили студентов, коллег и групп, их статистики и контакты
 
### Интерфейс пользователя

- Страница авторизации Web-приложения <br>
 ![AuthorizationPage](Mockups/Sign_In_Page/Sign_In.png)

- Страницп таблицы с оценками <br>
 ![AssessmentTablePage](Mockups/Sign_In_Page/Table.png)
  
 - Персональная страница 
 ![PersonalePage](Mockups/Sign_In_Page/Profile.png)

 - Таблица с предметами студента
 ![TableThingStudent](Mockups/Sign_In_Page/Objects_for_Student.png)

 - Таблица с предметами и группами преподавателя 
 ![TableThingTeacher](Mockups/Sign_In_Page/Objects_for_Teachers.png)

 - Страница поиска 
 ![Search](Mockups/Sign_In_Page/Founder.png)


### Характеристики пользователей


### 2.3.1 Аудитория приложения

#### 2.3.1.1 Целевая аудитория

Преподаватели и студенты различных учебных заведений.


#### 2.3.1.2 Побочная аудитория

Родители контролирующие своих детей.


# 3 Системные требования


## 3.1 Функциональные требования


### 3.1.1 Основные функции

#### 3.1.1.1 Вход и выход над учетной записью

Пользователь может войти\выйти в свой аккаунт.

#### 3.1.1.1 Выставление оценок

Преподаватель может выставлять оценки.

#### 3.1.1.1 Комментирование оценок от преподавателя

Преподаватель может ставить комментарий к оценке.

#### 3.1.1.1 Просмотр профиля студента\преподавателя

Пользователи системы могут просматривать профили других студентов или преподавателей.

### 3.1.2 Дополнительные функции

#### 3.1.2.1 Возможность изменить пароль.

Пользователь может сделать запрос на изменение пароля.

## 3.2 Нефункциональные требования

### 3.2.1 Атрибуты качества
| Требование | Описание |
|:---|:---|
| Производительность | Приложение работает в соответствии с требованиями при обычной пользовательской нагрузке. |
| Расширяемость | Новые версии приложения должны расширять его старый функционал, но не уменьшать/изменять его. |

### 3.2.2 Требования к удобству использования
1. Все элементы должны быть светлыми;
2. Все функциональные элементы пользовательского интерфейса имеют названия, описывающие действие, которое произойдет при выборе элемента;


### 3.2.3 Внешние интерфейсы
Странициы Web-приложения удобны для использования пользователями с плохим зрением :
  * размер шрифта не менее 14пт;
  * функциональные элементы контрастны фону страницы.
