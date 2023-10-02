# ONE-Challenge-Foro-Alura 💬

This repository contains the implementation of Spring Boot (Security, JPA, OpenAPI) to connect a MySQL database to a RESTful API to replicate a forum persistence system and storage users, courses and topics. In addition, includes a user register function to create new users and storage their credentials using BCrypt encryption.

<b>*This project was designed as a challenge for Oracle Next Education's Back-End bootcamp.*</b>
<br>

<img src="https://media.discordapp.net/attachments/1082508875292483594/1158456456035717171/scrnli_2_10_2023_11-19-52.png?ex=651c5026&is=651afea6&hm=1962782e7f45f402bd93c0f6b6e5224a9e28d4d38a3dbe5f88f33e395d1c4c9b" width="1000px"></img>
<img src="https://media.discordapp.net/attachments/1082508875292483594/1158456455792435241/Captura_de_pantalla_1586.png?ex=651c5026&is=651afea6&hm=fe1111d3a3e54fb74f9ab75a0cad9f8e25daac860cf4aa153051c9c1d41f1e5e" width="1000px"></img>
<img src="https://media.discordapp.net/attachments/1082508875292483594/1158456455557562499/Captura_de_pantalla_1585.png?ex=651c5026&is=651afea6&hm=829fcb53f861fd3f123a86c860d7366fe5b21748d5a50c7636db839d55f9bdb1" width="1000px"></img>

<h2>Table of Contents</h2>
<ul>
  <li><a href="#Technologies">Technologies 🔌</a></li>
  <li><a href="#Features">Features 💡</a></li>
  <li><a href="#Usage">Usage 👩‍💻</a></li>
  <li><a href="#Contributing">Contributing 👥</a></li>
  <li><a href="#License">License 📄</a></li>
 </ul>

<h2 id="Technologies">Technologies 🔌</h2>
<ul>
  <li>Spring Boot 3.</li>
  <li>OpenAPI (for documentation).</li>
  <li>JSON Web Token (JWT).</li>
  <li>Maven. </li>
  <li>FlyWayDB. </li>
  <li>MySQL Database.</li>
</ul>

<h2 id="Features">Features 💡</h2>
<ul>
  <li><b>RESTful API: </b>With an easy-to-use interface, users can quickly create new reservations, new guests and manage each at database level without technical knowledge.</li>
  <li><b>Authentication system : </b>Featuring a connection with a users database table, encrypts it's password and prevents the undesired use of this system from unauthorized users.</li>
  <li><b>JWT Token system : </b>By default, it blocks any request (except: /login & /user POST methods). In order to get a BearToken, authenticate through /login providing valid credentials.</li>
  <li><b>CRUD Support: </b>The entity "Topico" (topic) allows any HTTP request with valid JWT Token to Create, Read, Update and Delete (CRUD) to all or by any given id (GET, DELETE, UPDATE).</li>
  <li><b>OpenAPI documentation: </b>To review and test the API, OpenAPI was implementated to provide a quick view of this project.</li>
 </ul>

<h2 id="Usage">Usage 👩‍💻</h2>
<ul>
  <li>Import the repository into any JAVA IDE project (such as Eclipse) as Maven Project.</li>
  <li>Create a MySQL database in your localhost named "foro-alura-db" and FlyWayDB will do the rest.</li>
  <li>If you don't want to use those settings, edit <i>/main/resources/application.properties</i> file.</li>
</ul>

<h2 id="Contributing">Contributing 👥</h2>
Contributions are welcome! To contribute to the project, follow these steps:

<ol>
  <li>Fork the repository.</li>
  <li>Create a new branch with your feature or bug fix.</li>
  <li>Make changes and commit them.</li>
  <li>Push to your forked repository.</li>
  <li>Submit a pull request to the original repository.</li>
</ol>

<h2 id="License">License 📄</h2>
This project is licensed under the <u><i>MIT License</i></u>.
