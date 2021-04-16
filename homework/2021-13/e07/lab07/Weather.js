import React from "react";
import { Text, Image } from "react-native";

import { OPEN_WEATHER_KEY } from "./api_keys.js";
// What's the actual proper way to hide API keys?

export default function Weather({ lat, lon }) {
  // const url = "https://swapi.dev/api/people/1";
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${OPEN_WEATHER_KEY}&units=metric`;
  // console.log(url);

  const [icon, setIcon] = React.useState(null);
  const [temp, setTemp] = React.useState("Loading...");

  React.useEffect(() => {
    setTemp("Loading...");
    fetch(url)
      .then((data) => data.json())
      .then((weather) => {
        // console.log(weather?.weather[0]?.icon);
        // console.log(weather?.main?.temp);
        if (weather?.weather[0]?.icon && weather?.main?.temp) {
          setTemp(weather.main.temp);
          setIcon(weather.weather[0].icon);
        } else setTemp("Error");
      });
  }, []);

  return (
    <>
      <Image
        source={{ uri: `http://openweathermap.org/img/wn/${icon}@2x.png` }}
        style={{ width: 100, height: 100 }}
      />
      <Text>{temp} °C</Text>
    </>
  );
}
