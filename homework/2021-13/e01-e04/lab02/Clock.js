import React from "react";
import { Text, View, Button } from "react-native";

function Clock() {
  let [time, setTime] = React.useState(new Date().toString());

  const updateTime = () => {
    setTime(new Date().toString());
  };
  React.useEffect(() => {
    console.log("mounted");
    const id = setInterval(updateTime, 1000);
    return () => {
      console.log("unmounted");
      clearInterval(id);
    };
  }, []);

  return (
    <View>
      <Text>{time}</Text>
      {/* <Button
        onPress={() => setTime(new Date().toString())}
        title="Update"
        color="#841584"
      /> */}
    </View>
  );
}

export default Clock;
