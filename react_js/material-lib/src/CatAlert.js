import React from 'react';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';

export default function CatAlert() {
  return (
    // Stack: 여러 Alert를 세로로 쌓아서 보여줄 때 사용
    <Stack spacing={2}>
      {/* success 타입 */}
      <Alert severity="success">완료되었습니다!</Alert>

      {/* info 타입 */}
      <Alert severity="info">이건 정보 메시지입니다.</Alert>

      {/* warning 타입 */}
      <Alert severity="warning">경고! 확인이 필요합니다.</Alert>

      {/* error 타입 */}
      <Alert severity="error">오류 발생! 다시 시도하세요.</Alert>
    </Stack>
  );
}
