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
} from "@mui/material";
import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import '.././common.css';

function AccordionExpandFullRow({data}) {
  const [open, setOpen] = useState(false);
  const navigate = useNavigate();

  function printStar(count, unitRarity){
    return <h4 className={`unitRarity${unitRarity}`}>{"★".repeat(count)}</h4>;
  }
  return (
    <TableContainer component={Paper} sx={{marginBottom:'40px'}}>
      <Table>
        <TableBody>
          <TableRow sx={{height:'50px'}}>
            {/* 1열 */}
            <TableCell>{data.playerInfos[data.myIndex].placement}등</TableCell>
            <TableCell colSpan={3}>{data.queueType} | {data.playerInfos[data.myIndex].timeElemented} | {data.gameDatetime}</TableCell>
            {/* 2열 병합 + 토글 버튼 */}
            <TableCell rowSpan={2}  sx={{
               verticalAlign: "bottom", 
               backgroundColor: "grey",
               width:"15px"
              }}>
              <IconButton
                aria-label="expand"
                size="small"
                onClick={() => setOpen(!open)}
                sx={{color:"white !important"}}
              >
                {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
              </IconButton>
            </TableCell>
          </TableRow>
          <TableRow sx={{height:'90px'}}>
            <TableCell className="cellWidth">
              <div className="playerCell">
              <img className="playerTactician" src={data.playerInfos[data.myIndex].tacticianImgURL} alt="tactician"></img>
              <h4 className="playerLevel">{data.playerInfos[data.myIndex].level}</h4>
              </div>
            </TableCell>
            <TableCell className="traitWidth">
              <div className="traitCell">
              {data.playerInfos[data.myIndex].traitList.slice(0, data.playerInfos[data.myIndex].traitList.length).map((trait, index) => (
                <img key={index} className={`trait traitTier${trait.style}`}src={trait.imgURL} alt="traitImg"></img>
              ))}
              </div>
            </TableCell>
            <TableCell className="unitWidth">
              <div className="unitCell">
              {data.playerInfos[data.myIndex].unitList.slice(0, data.playerInfos[data.myIndex].unitList.length).map((unit, index) => (
                <div className="unit">
                  {printStar(unit.tier, unit.rarity)}
                  <img key={index} className={`unitImg unitRarity${unit.rarity}`}src={unit.imgURL} alt="unitImg"></img> 
                   <div>
                     <div className="item">
                  {unit.itemList.slice(0, unit.itemList.length).map((item, index) => (
                      <img key={index} className="itemImg" src={item.imgURL} alt="itemImg"></img>
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
                        {player.playerId.length <= 8 ? player.playerId : player.playerId.slice(0, 8) + "..."}
                      </div>
                  </div>
                ))}
              </div>
            </TableCell>
          </TableRow>

          {open && (
            <TableRow>
              <TableCell colSpan={5} style={{ paddingBottom: 0, paddingTop: 0 }}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                  <Box margin={2}>
                    <Typography variant="h6" gutterBottom>
                        확장 테이블
                    </Typography>
                    <Table size="small" aria-label="expanded table">
                      <TableHead>
                        <TableRow sx={{"& th, &td": {textAlign:"center"},}}>
                          <TableCell style={{width:'5%'}}>등수</TableCell>
                          <TableCell style={{width:'10%'}}>플레이어</TableCell>
                          <TableCell style={{width:'7%'}}>라운드</TableCell>
                          <TableCell style={{width:'15%'}}>특성</TableCell>
                          <TableCell style={{width:'56%'}}>챔피언</TableCell>
                          <TableCell style={{width:'7%'}}>업적</TableCell>
                        </TableRow>
                      </TableHead>
                      <TableBody>
                        <TableRow>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                          <TableCell>1</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                          <TableCell>2</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                          <TableCell>3</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                          <TableCell>4</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                          <TableCell>5</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                          <TableCell>6</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                          <TableCell>7</TableCell>
                        </TableRow>
                        <TableRow>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                          <TableCell>8</TableCell>
                        </TableRow>
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
