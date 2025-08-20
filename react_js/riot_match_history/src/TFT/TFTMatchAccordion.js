import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Collapse,
  IconButton,
  Box,
  Typography,
  Tooltip
} from "@mui/material";
import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import './TFTAccordian.css';
import '../reset.css';

function AccordionExpandFullRow({ data }) {
  const [open, setOpen] = useState(false);
  const navigate = useNavigate();

  function printUnitTier(count, unitRarity) {
    return <h4 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h4>;
  }
  function printExUnitTier(count, unitRarity) {
    return <h5 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h5>;
  }
  return (
    <TableContainer component={Paper} sx={{ marginBottom: '20px', backgroundColor: 'rgb(70, 70, 70)' }}>
      <Table>
        <TableBody>
          <TableRow sx={{ height: '50px' }}>
            <TableCell className={`playerPlacement${data.playerInfos[data.myIndex].placement}`} sx={{ textAlign: "center", fontWeight: '800' }}>#{data.playerInfos[data.myIndex].placement}</TableCell>
            <TableCell sx={{ color: 'rgb(170, 170, 170)' }} colSpan={3}>{data.queueType} | {data.playerInfos[data.myIndex].timeElemented} | {data.gamePassedtime}</TableCell>
            <TableCell rowSpan={2} className={`playerPlacement${data.playerInfos[data.myIndex].placement}`}
              sx={{
                verticalAlign: "bottom",
                width: "15px"
              }}>
              <IconButton
                aria-label="expand"
                size="small"
                onClick={() => setOpen(!open)}
                sx={{ color: "white !important" }}>
                {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
              </IconButton>
            </TableCell>
          </TableRow>
          <TableRow sx={{ height: '90px' }}>
            <TableCell className="cellWidth">
              <div className="playerCell">
                <Tooltip title={data.playerInfos[data.myIndex].tacticianName}>
                  <img className="playerTactician" src={data.playerInfos[data.myIndex].tacticianImgURL} alt="tactician"></img>
                </Tooltip>
                <h4 className="playerLevel">{data.playerInfos[data.myIndex].level}</h4>
              </div>
            </TableCell>
            <TableCell className="traitWidth">
              <div className="traitCell">
                {data.playerInfos[data.myIndex].traitList.slice(0, data.playerInfos[data.myIndex].traitList.length).map((trait, index) => (
                  <Tooltip title={trait.name}>
                    <img key={index} className={`traitImg traitTier${trait.style}`} src={trait.imgURL} alt="traitImg"></img>
                  </Tooltip>
                ))}
              </div>
            </TableCell>
            <TableCell className="unitWidth">
              <div className="unitCell">
                {data.playerInfos[data.myIndex].unitList.slice(0, data.playerInfos[data.myIndex].unitList.length).map((unit, index) => (
                  <div className="unitBox">
                    {printUnitTier(unit.tier, unit.rarity)}
                    <Tooltip title={unit.name}>
                      <div className={`unitImg unitRarity${unit.rarity}`}>
                        <img key={index} className="unitSprite" src={unit.imgURL} alt="unitImg"></img>
                      </div>
                    </Tooltip>
                    <div>
                      <div className="itemBox">
                        {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                          <Tooltip title={item.name}>
                            <img key={index} className="itemImg" src={item.imgURL} alt="itemImg"></img>
                          </Tooltip>
                        ))}
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </TableCell>
            <TableCell className="matchmateWidth">
              <div className="matchmateCell">
                {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                  <div key={index} className="matchmate">
                    <img className="matchmateIcon" src={player.tacticianImgURL} alt="tacticianImg"></img>
                    <div
                      className="matchmateName"
                      onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                      {player.playerId}</div>
                  </div>
                ))}
              </div>
            </TableCell>
          </TableRow>

          {open && ( //확장 테이블
            <TableRow>
              <TableCell colSpan={5} style={{ paddingBottom: 0, paddingTop: 0, color: "rgb(170, 170, 170)" }}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="subtitle2" gutterBottom textAlign="right">
                      일자 | {data.gameDatetime} / 버전 | {data.gameVersion}
                    </Typography>
                    <Table size="small" aria-label="expanded table">
                      <TableHead>
                        <TableRow sx={{ "& th, &td": { color: "rgb(170, 170, 170)" } }}>
                          <TableCell sx={{ width: '6%', textAlign: "center" }}>등수</TableCell>
                          <TableCell sx={{ width: '14%', textAlign: "center" }}>플레이어</TableCell>
                          <TableCell sx={{ width: '7%', textAlign: "center" }}>라운드</TableCell>
                          <TableCell sx={{ width: '15%', textAlign: "center" }}>특성</TableCell>
                          <TableCell sx={{ width: '40%', textAlign: "center" }}>챔피언</TableCell>
                          <TableCell sx={{ width: '6%' }}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        {data.playerInfos.slice(0, data.playerInfos.length).map((player, index) => (
                          <TableRow>
                            <TableCell sx={{ color: "rgb(170, 170, 170)", textAlign: "center" }}>{player.placement}</TableCell>
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <div className="exPlayerCell">
                                <Tooltip title={player.tacticianName}>
                                  <img className="exPlayerTactician" src={player.tacticianImgURL} alt="tactician"></img>
                                </Tooltip>
                                <div className="exPlayerLevel">{player.level}</div>
                                <div className="exPlayerId" onClick={() => navigate(`/TFTRecord?id=${player.playerId}&tag=${player.playerTag}`)}>
                                  {player.playerId}</div>
                              </div></TableCell>
                            <TableCell sx={{ color: "rgb(170, 170, 170)", textAlign: "center" }}>{player.lastRound}<br />{player.timeElemented}</TableCell>
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <div className="exTraitCell">
                                {player.traitList.slice(0, player.traitList.length).map((trait, index) => (
                                  <Tooltip title={trait.name}>
                                    <img key={index} className={`exTraitImg traitTier${trait.style}`} src={trait.imgURL} alt="exTraitImg"></img>
                                  </Tooltip>
                                ))}
                              </div>
                            </TableCell>
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <div className="exUnitCell">
                                {player.unitList.slice(0, player.unitList.length).map((unit, index) => (
                                  <div className="exUnitBox">
                                    {printExUnitTier(unit.tier, unit.rarity)}
                                    <Tooltip title={unit.name}>
                                      <div className={`exUnitImg unitRarity${unit.rarity}`}>
                                        <img key={index} className="exUnitSprite" src={unit.imgURL} alt="exUnitImg"></img>
                                      </div>
                                    </Tooltip>
                                    <div>
                                      <div className="exItemBox">
                                        {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                                          <Tooltip title={item.name}>
                                            <img key={index} className="exItemImg" src={item.imgURL} alt="exItemImg"></img>
                                          </Tooltip>
                                        ))}
                                      </div>
                                    </div>
                                  </div>
                                ))}
                              </div>
                            </TableCell>
                            <TableCell sx={{ color: "rgb(170, 170, 170)" }}>
                              <Tooltip title="입힌 피해량">{player.totalDamage}</Tooltip><br />
                              <Tooltip title="남은 골드">{player.goldLeft}</Tooltip>
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

export default AccordionExpandFullRow;
