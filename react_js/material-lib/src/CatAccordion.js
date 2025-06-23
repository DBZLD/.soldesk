import React from 'react';
import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

export default function CatAccordion() {
  return (
    <div>
      {/* Accordion: 펼칠 수 있는 박스 컴포넌트 */}
      <Accordion>
        {/* AccordionSummary: 접힌 상태에서 보이는 제목 부분 */}
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />} // 펼치기 아이콘
          aria-controls="panel1-content"
          id="panel1-header"
        >
          <Typography>고양이의 일상</Typography>
        </AccordionSummary>

        {/* AccordionDetails: 펼쳤을 때 나오는 본문 내용 */}
        <AccordionDetails>
          <Typography>
            고양이는 하루 대부분을 자며 보냅니다. 가끔 놀거나 밥을 먹기도 합니다.
          </Typography>
        </AccordionDetails>
      </Accordion>

      <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel2-content"
          id="panel2-header"
        >
          <Typography>고양이의 능력</Typography>
        </AccordionSummary>
        <AccordionDetails>
          <Typography>
            민첩하고 조용하며, 어두운 곳에서도 잘 보고, 높은 곳을 잘 탑니다.
          </Typography>
        </AccordionDetails>
      </Accordion>
    </div>
  );
}
