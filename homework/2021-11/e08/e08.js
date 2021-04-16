var readlineSync = require("readline-sync");
const fetch = require("node-fetch");

async function fetchTitle(id) {
  const url = "https://swapi.dev/api/people/" + id;
  const response = await fetch(url);
  const data = await response.json();

  if ("films" in data) {
    const filmResponse = await fetch(data.films[0]);
    const film = await filmResponse.json();
    // console.log(film);
    if (film && "title" in film) {
      return "First film title: " + film.title;
    } else return "Not found.";
  } else return "Not found.";
}

var id = readlineSync.questionInt("give id: ");
fetchTitle(id).then((title) => console.log(title));
