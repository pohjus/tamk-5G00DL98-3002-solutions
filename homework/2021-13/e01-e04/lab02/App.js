import { StatusBar } from "expo-status-bar";
import React from "react";
import { Button, StyleSheet, Text, View } from "react-native";

import Clock from "./Clock.js";
export default function App() {
  let [toggle, setToggle] = React.useState(true);

  return (
    <View style={styles.container}>
      {toggle ? <Clock /> : null}
      <Button onPress={() => setToggle(!toggle)} title="Toggle" />
      <StatusBar style="auto" />
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
