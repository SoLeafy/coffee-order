import { Container } from "@mui/material";
import React from "react";

const MobileLayout = ({ children }) => {
  return (
    <Container maxWidth="sm" sx={{ minHeight: "100vh", py: 2 }}>
      {/* <Header /> */}
      {children}
      {/* <BottomNav /> */}
    </Container>
  );
};

export default MobileLayout;
