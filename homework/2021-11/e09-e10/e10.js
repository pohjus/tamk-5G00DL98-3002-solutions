var readlineSync = require("readline-sync");
const fetch = require("node-fetch");

async function fetchTitle(url) {
  const filmResponse = await fetch(url);
  const film = await filmResponse.json();
  if (film && "title" in film) {
    return "First film title: " + film.title;
  } else return "Not found.";
}

async function fetchAllTitles(id) {
  const url = "https://swapi.dev/api/people/" + id;
  const response = await fetch(url);
  const data = await response.json();

  if ("films" in data && "name" in data) {
    const promises = [];
    data.films.map((film) => {
      promises.push(fetchTitle(film));
    });
    const movies = await Promise.all(promises);
    return { name: data.name, movies };
  } else return "Not found.";
}

async function fetchAll(ids) {
  const promises = [];
  ids.map((id) => {
    promises.push(fetchAllTitles(id));
  });
  return await Promise.all(promises);
}

var ids = [];
process.argv.forEach((arg, index) => {
  // Add all integer command line arguments to id array
  if (index > 1 && !isNaN(arg)) ids.push(arg);
});
// console.log(ids);

fetchAll(ids).then((data) => console.log(data));
