import { StatusBar } from "expo-status-bar";
import React from "react";
import {
  StyleSheet,
  Text,
  View,
  TextInput,
  Button,
  ScrollView,
  SafeAreaView,
} from "react-native";
import People from "./People.js";
import Person from "./Person.js";

export default function App() {
  const [IDField, setIDField] = React.useState(null);
  const [ID, setID] = React.useState(1);

  return (
    <View style={{ margin: 30, marginTop: 50 }}>
      <StatusBar style="auto" />
      <View alignItems="center" style={{ marginBottom: 30 }}>
        <Person id={ID} />
        <TextInput
          onChangeText={setIDField}
          text={IDField}
          placeholder="Character ID"
          keyboardType="numeric"
          textAlign="center"
        />
        <Button title="Search" onPress={() => setID(IDField)} />
      </View>
      <View alignItems="center">
        <People />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
