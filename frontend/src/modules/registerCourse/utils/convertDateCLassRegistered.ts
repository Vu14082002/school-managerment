const convertDateCLassRegistered = (dateStr: string): string => {
    const extractedDate = dateStr.substring(1, 9);

    const year = extractedDate.substring(0, 4);
    const month = extractedDate.substring(4, 6);
    const day = extractedDate.substring(6, 8);

    return `${day}/${month}/${year}`;
};

export default convertDateCLassRegistered;
