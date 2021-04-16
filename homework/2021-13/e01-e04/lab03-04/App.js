import { StatusBar } from "expo-status-bar";
import React from "react";
import { Button, StyleSheet, Text, TextInput, View } from "react-native";

import Clock from "./Clock.js";
export default function App() {
  let [toggle, setToggle] = React.useState(true);
  let [locale, setLocale] = React.useState(null);

  return (
    <View style={styles.container}>
      {toggle ? <Clock locale={locale} /> : null}
      {toggle ? (
        <TextInput
          onChangeText={setLocale}
          text={locale}
          placeholder="Locale"
          autoCapitalize="none"
        />
      ) : null}
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
