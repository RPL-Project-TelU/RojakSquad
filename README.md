
# E Reference Web Application

E Reference App for uploading and reading pdf Book, powered by [Spring Framework](https://spring.io/projects/spring-boot).

![referenceGif](https://user-images.githubusercontent.com/38776020/176658761-2dd6bbef-485a-4957-a8b3-5db868ca0d81.gif)

## Installation

Start by clone this repository through your directory

```bash
  git clone https://github.com/RPL-Project-TelU/RojakSquad.git
  cd RojakSquad
```

Please install the prequisites below to start using the app

 - [Maven](https://maven.apache.org/install.html) - Install Maven
 - [Postgresql](https://www.postgresql.org/download/) - Install Postgresql

  create database buku by using postgresql command line
    
        create DATABASE buku;

  You can also change the properties of your database in application.properties

        spring.datasource.url=jdbc:postgresql://localhost:5432/buku # Your database name
        spring.datasource.username=postgres         # Your Database username
        spring.datasource.password=123456           # Your Database Password



Start The Application by simply running MvcReferenceApplication.java



   ## Getting Started

Type this url in your adress bar to use the app

```bash
  localhost:8080
```


## API Reference

#### Search a Book

```http
  GET /search?=${judul}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `judul` | `string` | **Required**. Title of the book to fetch|

#### Open a Book

```http
  GET /buku?=${buku.judul}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `judul`      | `string` | **Required**. Title of the book to fetch |


#### Add a Book

```http
  GET /add
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `buku`      | **Object** Buku | **Required**.  Title of the book to add |


#### Delete a Book

```http
  DELETE /delete?=${buku.judul}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `buku`      | **Object** Buku | **Required**. Id of item to delete |

## Documentation

For our documentation Click

[Documentation](https://docs.google.com/document/d/1wMqknaVnEJZovpjgaQcHMxHhvA2pCrdwKvFbmD2cGLY/edit)

## Authors

- [Kevin](https://github.com/Pownyfals)
- [Razqy](https://github.com/razqyaqil)
- [Ismi](https://github.com/ismiwrdnta)
- [Jeksilaen](https://github.com/jeksilaen)
- [Syabila](https://github.com/syabilie)


## Feedback

If you have any feedback, please reach out to us at pownyfals@gmail.com

