#!/bin/bash
cd ../
awk '{printf "%s" , $0}' update_log.md > update_log.md.tmp
dataline=$(cat  update_log.md.tmp)
rm update_log.md.tmp

echo $dataline

git add -A

git commit -m $dataline


# 不关闭窗口
exec /bin/bash
