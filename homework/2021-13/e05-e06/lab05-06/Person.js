import React from "react";
import { Text } from "react-native";

export default function Person({ id }) {
  const url = "https://swapi.dev/api/people/" + id;
  console.log(url);

  const [name, setName] = React.useState("Loading...");

  console.log(name);

  React.useEffect(() => {
    setName("Loading...");
    fetch(url)
      .then((data) => data.json())
      .then((person) => {
        if (person?.name) setName(person.name);
        else setName("Error");
      });
  }, [id]);

  return <Text>{name}</Text>;
}
