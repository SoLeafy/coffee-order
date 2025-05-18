import { Box, Card, CardContent, Typography } from "@mui/material";
import Banner from "../components/Banner";
import FullNavButton from "../components/FullNavButton";
import MobileLayout from "../components/MobileLayout";

const Home = () => {
  return (
    <div>
      <MobileLayout>
        {/* 헤더 영역 */}
        <Box>
          <Typography variant="h5" component="h1" gutterBottom>
            ☕ 커피 함께 주문하기
          </Typography>
        </Box>

        <Banner />

        {/* 현재 카페 표시 영역 */}
        {/* <Box className="mb-4 p-4 bg-gray-100 rounded">
          <Typography variant="subtitle1">현재 선택된 카페</Typography>
          <Typography variant="body2" color="text.secondary">
            스타벅스 강남점
          </Typography>
        </Box> */}

        {/* 신규 주문 시작 버튼 */}
        <Box>
          <FullNavButton
            navigateTo="/create/select-cafe"
            text="새 주문 만들기"
          />
        </Box>

        {/* 내 주문 보기 카드 */}
        <Card className="mb-4">
          <CardContent>
            <Typography variant="body1">참여 중인 주문이 없습니다.</Typography>
          </CardContent>
        </Card>
      </MobileLayout>
    </div>
  );
};

export default Home;
