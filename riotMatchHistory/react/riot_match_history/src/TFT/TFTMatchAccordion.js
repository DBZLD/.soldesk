import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Collapse, IconButton, Box, Typography, Tooltip } from "@mui/material";
import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import './TFTAccordian.css';

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
            <TableCell className={`playerPlacement${data.playerInfos[data.myIndex].placement}`} sx={{ textAlign: "center", fontWeight: '800' }}> {/* 1행 1열(등수) */}
              #{data.playerInfos[data.myIndex].placement} {/* 등수 텍스트 */}
            </TableCell>
            <TableCell sx={{ color: 'rgb(170, 170, 170)' }} colSpan={3}> {/* 1행 2,3,4열(매치 타입, 소요시간) */}
              {data.queueType} | {data.playerInfos[data.myIndex].timeElemented} | {data.gamePassedtime} {/* 매치 타입, 게임 시간, 게임 경과 시간 */}
            </TableCell>
            <TableCell rowSpan={2} className={`playerPlacement${data.playerInfos[data.myIndex].placement}`} sx={{ verticalAlign: "bottom", width: "15px" }}> {/* 1,2행 5열(테이블 확장 버튼) */}
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
            <TableCell sx={{ width: '7%' }}> {/* 2행 1열(플레이어 정보) */}
              <Box sx={{ position: 'relative', display: 'flex', justifyContent: 'center', alignItems: 'center', color: 'rgba(24, 14, 78, 1)' }}>
                <Tooltip title={data.playerInfos[data.myIndex].tacticianName}> {/* 플레이어 전설이 툴팁 */}
                  <Box component="img"
                    src={data.playerInfos[data.myIndex].tacticianImgURL} alt="tactician" // 플레이어 전설이 이미지
                    sx={{ width: 50, height: 50, borderRadius: '50%', border: '3px solid' }}
                  />
                </Tooltip>
                <Typography sx={{ width: 20, height: 20, position: 'absolute', left: '63%', top: '57%', textAlign: 'center', backgroundColor: 'rgba(200,200,200,1)', color: 'rgba(24,14,78,1)', border: '2px solid', borderRadius: '50%', fontSize: 12 }}>
                  {data.playerInfos[data.myIndex].level} {/* 플레이어 레벨 텍스트 */}
                </Typography>
              </Box>
            </TableCell>

            <TableCell sx={{ width: '16%' }}> {/* 2행 2열(특성) */}
              <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', alignItems: 'flex-start' }}>
                {/* traitList 돌면서 모두 출력 */}
                {data.playerInfos[data.myIndex].traitList.map((trait, index) => (
                  <Tooltip key={index} title={trait.name}> {/* 특성 툴팁 */}
                    <Box component="img" className={`traitTier${trait.style}`} src={trait.imgURL} // 특성 이미지
                      alt="traitImg" sx={{ width: '25px', height: '25px', margin: '3px', borderRadius: '50%' }}
                    />
                  </Tooltip>
                ))}
              </Box>
            </TableCell>

            <TableCell sx={{ width: '53%' }}> {/* 2행 3열(유닛) */}
              <Box sx={{ display: 'flex', flexDirection: 'row', alignItems: 'flex-start' }}>
                {data.playerInfos[data.myIndex].unitList.map((unit, index) => (
                  <Box key={index} sx={{ width: 50, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
                    {printUnitTier(unit.tier, unit.rarity)} {/* 유닛 성 수 */}
                    <Tooltip title={unit.name}>
                      <Box className={`unitRarity${unit.rarity}`} sx={{ width: 37, height: 37, overflow: 'hidden', position: 'relative', border: '3px solid', borderRadius: '10%' }}>
                        <Box component="img" src={unit.imgURL} alt="unitImg"
                          sx={{ width: 100, height: 100, objectFit: 'none', objectPosition: '-130px 0px', transform: 'scale(0.37)', transformOrigin: 'top left', display: 'block' }}
                        />
                      </Box>
                    </Tooltip>
                    <Box sx={{ width: 39, display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                      {unit.itemList.map((item, idx) => (
                        <Tooltip key={idx} title={item.name}>
                          <Box component="img" src={item.imgURL} alt="itemImg" sx={{ width: 13, height: 13 }} />
                        </Tooltip>
                      ))}
                    </Box>
                  </Box>
                ))}
              </Box>
            </TableCell>

            <TableCell sx={{ width: '20%' }}> {/* 2행 4열(함께 매칭된 플레이어) */}
              <Box sx={{ display: 'flex', flexDirection: 'row', flexWrap: 'wrap', color: 'rgb(170, 170, 170)' }}>
                {data.playerInfos.map((player, index) => (
                  <Box key={index} sx={{ width: '50%', display: 'flex', flexDirection: 'row', mb: '5px' }}>
                    <Box component="img" src={player.tacticianImgURL} alt="tacticianImg" sx={{ width: 15, height: 15, borderRadius: '50%', marginRight: '4px', border: '1px, solid, rgba(24,14,78,1)' }} /> {/*플레이어 아이콘 이미지 */}
                    <Typography sx={{ width: 'auto', cursor: 'pointer', fontSize: 'x-small', fontWeight: 700, whiteSpace: 'nowrap', overflow: 'hidden', textOverflow: 'ellipsis' }}
                      onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                      {player.playerId} {/* 플레이어 아이디 */}
                    </Typography>
                  </Box>
                ))}
              </Box>
            </TableCell>
          </TableRow>

          {open && ( //open이 true일때
            <TableRow> {/* 확장 테이블 */}
              <TableCell colSpan={5} sx={{ paddingBottom: 0, paddingTop: 0, color: "rgb(170, 170, 170)" }}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="subtitle2" gutterBottom textAlign="right">
                      일자 | {data.gameDatetime} / 버전 | {data.gameVersion}
                    </Typography>
                    <Table size="small" aria-label="expanded table">
                      <TableHead>
                        <TableRow sx={{ "& th, & td": { color: "rgb(170, 170, 170)" } }}>
                          <TableCell sx={{ width: '6%', textAlign: "center" }}>등수</TableCell>
                          <TableCell sx={{ width: '14%', textAlign: "center" }}>플레이어</TableCell>
                          <TableCell sx={{ width: '7%', textAlign: "center" }}>라운드</TableCell>
                          <TableCell sx={{ width: '15%', textAlign: "center" }}>특성</TableCell>
                          <TableCell sx={{ width: '40%', textAlign: "center" }}>유닛</TableCell>
                          <TableCell sx={{ width: '6%' }}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        {data.playerInfos.map((player, index) => (
                          <TableRow key={index}>
                            <TableCell sx={{ color: "rgb(170, 170, 170)", textAlign: "center" }}>{player.placement}</TableCell> {/* 1행(등수) */}
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}> {/* 2행(플레이어) */}
                              <Box sx={{ position: 'relative', display: 'flex', alignItems: 'center', color: 'navy' }}>
                                <Tooltip title={player.tacticianName}> {/* 플레이어 전설이 툴팁 */}
                                  <Box component="img" src={player.tacticianImgURL} alt="tactician" sx={{ width: 30, height: 30, border: '2px solid', borderRadius: '50%' }} />
                                </Tooltip>
                                <Box sx={{ width: 15, height: 15, position: 'absolute', left: '12%', top: '57%', textAlign: 'center', backgroundColor: 'gray', border: '2px solid', borderRadius: '50%', fontSize: 'x-small', fontWeight: 700 }}>
                                  {player.level} {/* 플레이어 레벨 텍스트 */}
                                </Box>
                                <Typography sx={{ fontSize: 13, color: 'rgb(170,170,170)', marginLeft: '13px', cursor: 'pointer' }}
                                  onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                                  {player.playerId} {/* 플레이어 아이디 텍스트 */}
                                </Typography>
                              </Box>
                            </TableCell>

                            <TableCell sx={{ color: "rgb(170,170,170)", textAlign: 'center' }}>{player.lastRound}<br />{player.timeElemented}</TableCell> {/* 3행(라운드) */}

                            <TableCell sx={{ color: "rgb(170,170,170)" }}> {/* 4행(특성) */}
                              <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'flex-start', alignItems: 'flex-start' }}>
                                {player.traitList.map((trait, idx) => (
                                  <Tooltip key={idx} title={trait.name}>
                                    <Box component="img" className={`traitTier${trait.style}`} src={trait.imgURL} alt="exTraitImg" sx={{ width: '17px', height: '17px', m: '2px', mt: '6px', borderRadius: '50%' }} />
                                  </Tooltip>
                                ))}
                              </Box>
                            </TableCell>

                            <TableCell sx={{ color: "rgb(170,170,170)" }}> {/* 5행(유닛) */}
                              <Box sx={{ display: 'flex', flexDirection: 'row' }}>
                                {player.unitList.map((unit, idx) => (
                                  <Box key={idx} sx={{ width: 'auto', display: 'flex', margin: '2px', flexDirection: 'column', alignItems: 'center' }}>
                                    {printExUnitTier(unit.tier, unit.rarity)} {/* 유닛 성 수 텍스트 */}
                                    <Tooltip title={unit.name}>
                                      <Box className={`unitRarity${unit.rarity}`} sx={{ width: '30px', height: '30px', overflow: 'hidden', position: 'relative', border: '2px solid', borderRadius: '10%' }}>
                                        <Box component="img" src={unit.imgURL} alt="exUnitImg" sx={{ width: 100, height: 100, objectFit: 'none', objectPosition: '-130px 0px', transform: 'scale(0.3)', transformOrigin: 'top left', display: 'block' }} />
                                      </Box>
                                    </Tooltip>
                                    <Box sx={{ width: 36, display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                                      {unit.itemList.map((item, iidx) => (
                                        <Tooltip key={iidx} title={item.name}>
                                          <Box component="img" src={item.imgURL} alt="exItemImg" sx={{ width: 12, height: 12 }} />
                                        </Tooltip>
                                      ))}
                                    </Box>
                                  </Box>
                                ))}
                              </Box>
                            </TableCell>

                            <TableCell sx={{ color: "rgb(170,170,170)" }}> {/* 6행(업적) */}
                              <Tooltip title="입힌 피해량">
                                <Box sx={{ display: 'flex', alignItems: 'center' }}>
                                  <Box component="img" src="/resources/TotalDamageImg.png" alt="totalDamage" sx={{ width: 16, height: 16, borderRadius: '50%', mr: '5px' }} /> {/* 입힌 피해량 아이콘 */}
                                  {player.totalDamage}
                                </Box>
                              </Tooltip>
                              <Tooltip title="남은 골드">
                                <Box sx={{ display: 'flex', alignItems: 'center' }}>
                                  <Box component="img" src="/resources/LeftGoldImg.png" alt="leftGold" sx={{ width: 13, height: 13, borderRadius: '50%', mr: '5px' }} /> {/* 남은 골드 아이콘 */}
                                  {player.goldLeft}
                                </Box>
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
