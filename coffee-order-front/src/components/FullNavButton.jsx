import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";

const FullNavButton = ({ navigateTo, text }) => {
  const navigate = useNavigate();
  return (
    <Button
      variant="contained"
      color="success"
      fullWidth
      onClick={() => {
        navigate(navigateTo);
      }}
      sx={{ py: 1.5, fontWeight: "bold", fontSize: "1rem", mb: 2 }}
    >
      {text}
    </Button>
  );
};

export default FullNavButton;
