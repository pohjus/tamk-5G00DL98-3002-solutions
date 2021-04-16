import React from "react";
import { Text, FlatList, View } from "react-native";

export default function People() {
  const url = "https://swapi.dev/api/people/";

  const [people, setPeople] = React.useState(null);

  React.useEffect(() => {
    fetch(url)
      .then((data) => data.json())
      .then((ppl) => {
        // console.log(ppl);
        if (ppl) setPeople(ppl.results);
      });
  }, []);

  const renderItem = ({ item }) => (
    <View>
      <Text>{item.name}</Text>
    </View>
  );

  if (!people) return <Text>Loading...</Text>;
  else
    return (
      <FlatList
        data={people}
        renderItem={renderItem}
        keyExtractor={(item) => item.id}
      />
    );
}
