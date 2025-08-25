import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Collapse, IconButton, Box, Typography, Tooltip } from "@mui/material";
import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import './TFTAccordian.css';
import '../reset.css';

function TFTMatchAccordion({ data }) {
  const navigate = useNavigate();

  const [open, setOpen] = useState(false); //확장 여부

  function printUnitTier(count, unitRarity) { //유닛 성 수 출력 함수
    return <h4 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h4>; // 유닛 rarity에 맞는 스타일 적용 후 count만큼 출력
  }

  function printExUnitTier(count, unitRarity) { //유닛 성 수 출력 함수(확장 테이블)
    return <h5 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h5>; // 유닛 rarity에 맞는 스타일 적용 후 count만큼 출력
  }

  return (
    <TableContainer component={Paper} sx={{ marginBottom: '20px', backgroundColor: 'rgb(70, 70, 70)' }}> {/* 테이블 메인 컨테이너 */}
      <Table>
        <TableBody>
          <TableRow sx={{ height: '50px' }}> {/* 1행 */}
            {/* 1행 1열(등수) */}
            <TableCell className={`playerPlacement${data.playerInfos[data.myIndex].placement}`} sx={{ textAlign: "center", fontWeight: '800' }}>
              #{data.playerInfos[data.myIndex].placement} {/* 등수 텍스트 */}
            </TableCell>
            {/* 1행 2열(매치 타입, 소요시간) */}
            <TableCell sx={{ color: 'rgb(170, 170, 170)' }} colSpan={3}>
              {data.queueType} | {data.playerInfos[data.myIndex].timeElemented} | {data.gamePassedtime} {/* 매치 타입, 게임 시간, 게임 경과 시간 */}
            </TableCell>
            {/* 1행 3열(테이블 확장 버튼) */}
            <TableCell rowSpan={2} className={`playerPlacement${data.playerInfos[data.myIndex].placement}`} // 2행 병합
              sx={{
                verticalAlign: "bottom",
                width: "15px"
              }}>
              <IconButton //확장 아이콘
                aria-label="expand"
                size="small"
                onClick={() => setOpen(!open)}
                sx={{ color: "white !important" }}>
                {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />} {/* 확장 여부 설정 */}
              </IconButton>
            </TableCell>
          </TableRow>
          <TableRow sx={{ height: '90px' }}> {/* 2행 */}
            {/* 2행 1열(플레이어 정보) */}
            <TableCell sx={{ width: '7%' }}>
              <Box sx={{ position: 'relative', display: 'flex', justifyContent: 'center', alignItems: 'center', color: 'rgba(24, 14, 78, 1)' }}>
                {/* 플레이어 전설이 */}
                <Tooltip title={data.playerInfos[data.myIndex].tacticianName}>
                  <img src={data.playerInfos[data.myIndex].tacticianImgURL} alt="tactician" style={{ width: 50, height: 50, borderRadius: '50%', border: '3px solid' }} /> {/* 전설이 이미지 */}
                </Tooltip>
                {/* 플레이어 레벨 */}
                <Typography className="playerLevel">
                  {data.playerInfos[data.myIndex].level} {/* 레벨 텍스트 */}
                </Typography>
              </Box>

            </TableCell>
            {/* 2행 2열(특성) */}
            <TableCell sx={{ width: '16%' }}>
              <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', alignItems: 'flex-start' }}>
                {/* 특성 배열 돌면서 모두 출력 */}
                {data.playerInfos[data.myIndex].traitList.slice(0, data.playerInfos[data.myIndex].traitList.length).map((trait, index) => (
                  <Tooltip title={trait.name}>
                    <img key={index} className={`traitImg traitTier${trait.style}`} src={trait.imgURL} alt="traitImg" /> {/* 특성 이미지 */}
                  </Tooltip>
                ))}
              </Box>
            </TableCell>
            {/* 2행 3열(유닛) */}
            <TableCell sx={{ width: '53%' }}>
              <Box sx={{ display: 'flex', flexDirection: 'row', alignItems: 'flex-start' }}>
                {/* 유닛 배열 돌면서 모두 출력 */}
                {data.playerInfos[data.myIndex].unitList.slice(0, data.playerInfos[data.myIndex].unitList.length).map((unit, index) => (
                  <Box sx={{ width: '50px', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
                    {printUnitTier(unit.tier, unit.rarity)} {/* 유닛 성 수 */}
                    <Tooltip title={unit.name}>
                      <Box className={`unitImg unitRarity${unit.rarity}`}>
                        <img key={index} className="unitSprite" src={unit.imgURL} alt="unitImg" /> {/* 유닛 이미지 */}
                      </Box>
                    </Tooltip>
                    <Box sx={{ width: '39px', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                      {/* 유닛 아이템 배열 돌면서 모두 출력 */}
                      {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                        <Tooltip title={item.name}>
                          <img key={index} className="itemImg" src={item.imgURL} alt="itemImg" /> {/* 아이템 이미지 */}
                        </Tooltip>
                      ))}
                    </Box>
                  </Box>
                ))}
              </Box>
            </TableCell>
            {/* 2행 4열(함께 매칭된 플레이어) */}
            <TableCell sx={{ width: '20%' }}>
              <Box sx={{ display: 'flex', flexDirection: 'row', flexWrap: 'wrap', color: 'rgb(170, 170, 170)' }}>
                {/* 플레이어 배열 돌면서 모두 출력 */}
                {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                  <Box key={index} sx={{ width: '50%', display: 'flex', flexDirection: 'row', mb: '5px' }}>
                    <img className="matchmateIcon" src={player.tacticianImgURL} alt="tacticianImg" /> {/*플레이어 아이콘 이미지 */}
                    {/* 아이디 누르면 해당 플레이어 전적 페이지로 이동 */}
                    <Typography className="matchmateName" onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                      {player.playerId} {/* 플레이어 아이디 */}
                    </Typography>
                  </Box>
                ))}
              </Box>
            </TableCell>
          </TableRow>

          {open && ( //open이 true일때
            // 확장 테이블 설정
            <TableRow>
              <TableCell colSpan={5} sx={{ paddingBottom: 0, paddingTop: 0, color: "rgb(170, 170, 170)" }}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="subtitle2" gutterBottom textAlign="right">
                      일자 | {data.gameDatetime} / 버전 | {data.gameVersion}
                    </Typography>
                    <Table size="small" aria-label="expanded table">
                      {/* 테이블 상단 */}
                      <TableHead>
                        <TableRow sx={{ "& th, &td": { color: "rgb(170, 170, 170)" } }}>
                          <TableCell sx={{ width: '6%', textAlign: "center" }}>등수</TableCell>
                          <TableCell sx={{ width: '14%', textAlign: "center" }}>플레이어</TableCell>
                          <TableCell sx={{ width: '7%', textAlign: "center" }}>라운드</TableCell>
                          <TableCell sx={{ width: '15%', textAlign: "center" }}>특성</TableCell>
                          <TableCell sx={{ width: '40%', textAlign: "center" }}>유닛</TableCell>
                          <TableCell sx={{ width: '6%' }}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      {/* 테이블 하단 */}
                      <TableBody>
                        {/* 플레이어 배열 돌면서 모두 출력 */}
                        {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                          <TableRow>
                            {/* 1행(등수) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)", textAlign: "center" }}>{player.placement}</TableCell> {/* 등수 텍스트 */}
                            {/* 2행(플레이어) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <Box sx={{ position: 'relative', display: 'flex', alignItems: 'center', color: 'navy' }}>
                                <Tooltip title={player.tacticianName}> {/* 플레이어 전설이 툴팁 */}
                                  <img className="exPlayerTactician" src={player.tacticianImgURL} alt="tactician" /> {/* 플레이어 전설이 이미지 */}
                                </Tooltip>
                                <Box className="exPlayerLevel">{player.level}</Box> {/* 플레이어 레벨 텍스트 */}
                                <Typography className="exPlayerId" onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                                  {player.playerId}</Typography> {/* 플레이어 아이디 텍스트 */}
                              </Box>
                            </TableCell>
                            {/* 3행(라운드) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)", textAlign: "center" }}>
                              {player.lastRound}<br />{player.timeElemented} {/* 플레이어 생존 라운드, 시간 */}
                            </TableCell>
                            {/* 4행(특성) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <Box className="exTraitCell">
                                {/* 플레이어 특성 배열 돌면서 모두 출력 */}
                                {player.traitList.slice(0, player.traitList.length).map((trait, index) => (
                                  <Tooltip title={trait.name}> {/* 특성 툴팁 */}
                                    <img key={index} className={`exTraitImg traitTier${trait.style}`} src={trait.imgURL} alt="exTraitImg" /> {/* 특성 이미지 */}
                                  </Tooltip>
                                ))}
                              </Box>
                            </TableCell>
                            {/* 5행(유닛) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <Box className="exUnitCell">
                                {/* 플레이어 유닛 배열 돌면서 모두 출력 */}
                                {player.unitList.slice(0, player.unitList.length).map((unit, index) => (
                                  <Box className="exUnitBox">
                                    {printExUnitTier(unit.tier, unit.rarity)} {/* 유닛 성 수 텍스트 */}
                                    <Tooltip title={unit.name}> {/* 유닛 툴팁 */}
                                      <Box className={`exUnitImg unitRarity${unit.rarity}`}>
                                        <img key={index} className="exUnitSprite" src={unit.imgURL} alt="exUnitImg" /> {/* 유닛 이미지 */}
                                      </Box>
                                    </Tooltip>
                                    <Box>
                                      <Box className="exItemBox">
                                        {/* 유닛 아이템 배열 돌면서 모두 출력 */}
                                        {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                                          <Tooltip title={item.name}> {/* 아이템 툴팁 */}
                                            <img key={index} className="exItemImg" src={item.imgURL} alt="exItemImg" /> {/* 아이템 이미지 */}
                                          </Tooltip>
                                        ))}
                                      </Box>
                                    </Box>
                                  </Box>
                                ))}
                              </Box>
                            </TableCell>
                            {/* 6행(업적) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <Tooltip title="입힌 피해량"> {/* 남은 골드 툴팁 */}
                                {player.totalDamage} {/* 남은 골드 텍스트 */}
                              </Tooltip><br/>
                              <Tooltip title="남은 골드"> {/* 남은 골드 툴팁 */}
                                {player.goldLeft} {/* 남은 골드 텍스트 */}
                              </Tooltip>
                            </TableCell>
                          </TableRow>
                        ))}
                      </TableBody>
                    </Table>
                  </Box>
                </Collapse>
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default TFTMatchAccordion;
