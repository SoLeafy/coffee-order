import { Box } from "@mui/material";
import Slider from "react-slick";

const images = [
  "https://dk2dv4ezy246u.cloudfront.net/widgets/sSVPoAfKnFL_large.jpg",
  "https://cdn.vectorstock.com/i/2000v/00/14/cute-happy-nuts-banner-flat-cartoon-vector-29340014.avif",
  "https://cdn.goodkyung.com/news/photo/202102/137797_95931_1549.png",
];

const Banner = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    autoplay: true,
    slidesToShow: 1,
    slidesToScroll: 1,
  };

  return (
    <Box sx={{ width: "100%", maxWidth: "390px", mx: "auto", mb: 4, pb: 2 }}>
      <Slider {...settings}>
        {images.map((src, idx) => (
          <Box key={idx}>
            <img
              src={src}
              alt={`배너 ${idx + 1}`}
              style={{ width: "100%", height: "auto", borderRadius: "8px" }}
            />
          </Box>
        ))}
      </Slider>
    </Box>
  );
};

export default Banner;
