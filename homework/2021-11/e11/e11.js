const axios = require("axios").default;

// Run app.js in restful-api-nodejs -> localhost test api

/*
  curl http://localhost:8080/locations/
  curl http://localhost:8080/locations/1
  curl -X DELETE http://localhost:8080/locations/1
  curl -H "Content-type: application/json" -d "{\"lat\":65, \"lon\":66}" http://localhost:8080/locations/
*/

const URL = "http://localhost:8080/locations/";

async function addLocation({ lat, lon }) {
  return await axios
    .post(URL, {
      lat,
      lon,
    })
    .then((response) => response.data.id)
    .catch(function (error) {
      console.log(error);
    });
}

async function deleteLocation(id) {
  return await axios
    .delete(`${URL}${id}`)
    .then((response) => response.status)
    .catch(function (error) {
      throw "Location not found.";
    });
}

async function fetchAllLocations() {
  return await get(URL).then((response) => response.data);
}

async function fetchLocation(id) {
  return await get(`${URL}${id}`)
    .then((response) => response.data)
    .catch(function (error) {
      throw "Location not found.";
    });
}

const get = async (url) => {
  // let response = await axios.get(url);
  // console.log(response.data);
  return await axios.get(url);
};

const main = async () => {
  try {
    let id = await addLocation({ lat: 20, lon: 50 });
    console.log(id); // outputs id of the added location

    let statusCode = await deleteLocation(id);
    console.log(statusCode); // 204

    let locations = await fetchAllLocations();
    console.log(locations); // outputs all locations

    let location = await fetchLocation(1);
    console.log(location); // outputs location with id of 1
  } catch (err) {
    console.log(err);
  }
};
main();
