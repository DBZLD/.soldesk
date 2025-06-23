import React, { useState } from 'react';
import Stepper from '@mui/material/Stepper';
import Step from '@mui/material/Step';
import StepLabel from '@mui/material/StepLabel';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';

export default function CatStepper() {
  // 스텝 정의
  const steps = ['회원 정보 입력', '약관 동의', '가입 완료'];
  const [activeStep, setActiveStep] = useState(0);

  // 다음 단계
  const handleNext = () => setActiveStep((prev) => prev + 1);
  // 이전 단계
  const handleBack = () => setActiveStep((prev) => prev - 1);
  // 초기화
  const handleReset = () => setActiveStep(0);

  return (
    <Box sx={{ width: '100%', p: 2 }}>
      {/* Stepper: 스탭 진행 표시 바 */}
      <Stepper activeStep={activeStep}>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>

      {/* 현재 단계 콘텐츠 */}
      <Box sx={{ mt: 2, mb: 1 }}>
        {activeStep === steps.length ? (
          <Typography>🎉 회원가입이 완료되었습니다!</Typography>
        ) : (
          <Typography>현재 단계: {steps[activeStep]}</Typography>
        )}
      </Box>

      {/* 버튼 그룹 */}
      <Box sx={{ display: 'flex', flexDirection: 'row', pt: 2 }}>
        <Button 
          color="inherit"
          disabled={activeStep === 0}
          onClick={handleBack}
          sx={{ mr: 1 }}
        >
          이전
        </Button>
        <Box sx={{ flex: '1 1 auto' }} />
        {activeStep === steps.length ? (
          <Button onClick={handleReset}>처음으로</Button>
        ) : (
          <Button onClick={handleNext}>
            {activeStep === steps.length - 1 ? '완료' : '다음'}
          </Button>
        )}
      </Box>
    </Box>
  );
}
