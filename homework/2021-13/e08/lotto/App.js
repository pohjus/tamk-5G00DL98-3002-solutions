import { StatusBar } from "expo-status-bar";
import React from "react";
import { StyleSheet, View } from "react-native";
import MainGrid from "./components/MainGrid.js";

export default function App() {
  return (
    <View style={styles.container}>
      <MainGrid styles={styles} />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "flex-start",
    marginTop: 20,
  },
  containerGrid: {
    flex: 12,
    marginBottom: 0,
  },
  innerContainer: {
    margin: 10,
    // justifyContent: "flex-start",
  },
  title: {
    fontSize: 20,
    fontWeight: "bold",
  },
  roundButton: {
    borderRadius: 100,
    width: 40,
    height: 40,
    justifyContent: "center",
    alignItems: "center",
    padding: 10,
    borderColor: "black",
    borderWidth: 1,
    margin: 3,
  },
});
